"""distutils.archive_util

Utility functions for creating archive files (tarballs, zip files,
that sort of thing)."""

# This module should be kept compatible with Python 2.1.

__revision__ = "$Id: archive_util.py 37828 2004-11-10 22:23:15Z loewis $"

import os
from distutils.errors import DistutilsExecError
from distutils.spawn import spawn
from distutils.dir_util import mkpath
from distutils import log

def make_tarball (base_name, base_dir, compress="gzip",
                  verbose=0, dry_run=0):
    """Create a (possibly compressed) tar file from all the files under
    'base_dir'.  'compress' must be "gzip" (the default), "compress",
    "bzip2", or None.  Both "tar" and the compression utility named by
    'compress' must be on the default program search path, so this is
    probably Unix-specific.  The output tar file will be named 'base_dir' +
    ".tar", possibly plus the appropriate compression extension (".gz",
    ".bz2" or ".Z").  Return the output filename.
    """
    # XXX GNU tar 1.13 has a nifty option to add a prefix directory.
    # It's pretty new, though, so we certainly can't require it --
    # but it would be nice to take advantage of it to skip the
    # "create a tree of hardlinks" step!  (Would also be nice to
    # detect GNU tar to use its 'z' option and save a step.)

    compress_ext = { 'gzip': ".gz",
                     'bzip2': '.bz2',
                     'compress': ".Z" }

    # flags for compression program, each element of list will be an argument
    compress_flags = {'gzip': ["-f9"],
                      'compress': ["-f"],
                      'bzip2': ['-f9']}

    if compress is not None and compress not in compress_ext.keys():
        raise ValueError, \
              "bad value for 'compress': must be None, 'gzip', or 'compress'"

    archive_name = base_name + ".tar"
    mkpath(os.path.dirname(archive_name), dry_run=dry_run)
    cmd = ["tar", "-cf", archive_name, base_dir]
    spawn(cmd, dry_run=dry_run)

    if compress:
        spawn([compress] + compress_flags[compress] + [archive_name],
              dry_run=dry_run)
        return archive_name + compress_ext[compress]
    else:
        return archive_name

# make_tarball ()


def make_zipfile (base_name, base_dir, verbose=0, dry_run=0):
    """Create a zip file from all the files under 'base_dir'.  The output
    zip file will be named 'base_dir' + ".zip".  Uses either the "zipfile"
    Python module (if available) or the InfoZIP "zip" utility (if installed
    and found on the default search path).  If neither tool is available,
    raises DistutilsExecError.  Returns the name of the output zip file.
    """
    try:
        import zipfile
    except ImportError:
        zipfile = None

    zip_filename = base_name + ".zip"
    mkpath(os.path.dirname(zip_filename), dry_run=dry_run)

    # If zipfile module is not available, try spawning an external
    # 'zip' command.
    if zipfile is None:
        if verbose:
            zipoptions = "-r"
        else:
            zipoptions = "-rq"

        try:
            spawn(["zip", zipoptions, zip_filename, base_dir],
                  dry_run=dry_run)
        except DistutilsExecError:
            # XXX really should distinguish between "couldn't find
            # external 'zip' command" and "zip failed".
            raise DistutilsExecError, \
                  ("unable to create zip file '%s': "
                   "could neither import the 'zipfile' module nor "
                   "find a standalone zip utility") % zip_filename

    else:
        log.info("creating '%s' and adding '%s' to it",
                 zip_filename, base_dir)

        def visit (z, dirname, names):
            for name in names:
                path = os.path.normpath(os.path.join(dirname, name))
                if os.path.isfile(path):
                    z.write(path, path)
                    log.info("adding '%s'" % path)

        if not dry_run:
            z = zipfile.ZipFile(zip_filename, "w",
                                compr