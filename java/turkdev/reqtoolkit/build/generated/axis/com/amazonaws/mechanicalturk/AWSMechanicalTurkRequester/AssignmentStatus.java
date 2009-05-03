This is a generic INSTALL file for utilities distributions.
If this package does not come with, e.g., installable documentation or
data files, please ignore the references to them below.

To compile this package:

1.  Configure the package for your system.  In the directory that this
file is in, type `./configure'.  If you're using `csh' on an old
version of System V, you might need to type `sh configure' instead to
prevent `csh' from trying to execute `configure' itself.

The `configure' shell script attempts to guess correct values for
various system-dependent variables used during compilation, and
creates the Makefile(s) (one in each subdirectory of the source
directory).  In some packages it creates a C header file containing
system-dependent definitions.  It also creates a file `config.status'
that you can run in the future to recreate the current configuration.

Running `configure' takes a minute or two.  While it is running, it
prints some messages that tell what it is doing.  If you don't want to
see the messages, run `configure' with its standard output redirected
to `/dev/null'; for example, `./configure >/dev/null'.

To compile the package in a different directory from the one
containing the source code, you must use a version of `make' that
supports the VPATH variable, such as GNU `make'.  `cd' to the directory
where you want the object files and executables to go and run
`configure'.  `configure' automatically checks for the source code in
the directory that `configure' is in and in `..'.  If for some reason
`configure' is not in the source code directory that you are
configuring, then it will report that it can't find the source code.
In that case, run `configure' with the option `--srcdir=DIR', where
DIR is the directory that contains the source code.

By default, `make install' will install the package's files in
/usr/local/bin, /usr/local/lib, /usr/local/man, etc.  You can specify an
installation prefix other than /usr/local by giving `configure' the option
`--prefix=PATH'.  Alternately, you can do so by consistently giving a value
for the `prefix' variable when you run `make', e.g.,
	make prefix=/usr/gnu
	make prefix=/usr/gnu install

You can specify separate installation prefixes for
architecture-specific files and architecture-independent files.  If
you give `configure' the option `--exec-prefix=PATH' or set the
`make' variable `exec_prefix' to PATH, the package will use PATH as
the prefix for installing programs and libraries.  Data files and
documentation will still use the regular prefix.  Normally, all files
are installed using the regular prefix.

Another `configure' option is useful mainly in `Makefile' rules for
updating `config.status' and `Makefile'.  The `--no-create' option
figures out the configuration for your system and records it in
`config.status', without actually configuring the package (creating
`Makefile's and perhaps a configuration header file).  Later, you can
run `./config.status' to actually configure the packag