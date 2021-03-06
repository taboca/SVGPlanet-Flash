ine VIF_WRITEPROT           0x00000040L
#define VIF_FILEINUSE           0x00000080L
#define VIF_OUTOFSPACE          0x00000100L
#define VIF_ACCESSVIOLATION     0x00000200L
#define VIF_SHARINGVIOLATION    0x00000400L
#define VIF_CANNOTCREATE        0x00000800L
#define VIF_CANNOTDELETE        0x00001000L
#define VIF_CANNOTRENAME        0x00002000L
#define VIF_CANNOTDELETECUR     0x00004000L
#define VIF_OUTOFMEMORY         0x00008000L

#define VIF_CANNOTREADSRC       0x00010000L
#define VIF_CANNOTREADDST       0x00020000L

#define VIF_BUFFTOOSMALL        0x00040000L

#ifndef RC_INVOKED              /* RC doesn't need to see the rest of this */

/* ----- Types and structures ----- */

typedef struct tagVS_FIXEDFILEINFO
{
    DWORD   dwSignature;            /* e.g. 0xfeef04bd */
    DWORD   dwStrucVersion;         /* e.g. 0x00000042 = "0.42" */
    DWORD   dwFileVersionMS;        /* e.g. 0x00030075 = "3.75" */
    DWORD   dwFileVersionLS;        /* e.g. 0x00000031 = "0.31" */
    DWORD   dwProductVersionMS;     /* e.g. 0x00030010 = "3.10" */
    DWORD   dwProductVersionLS;     /* e.g. 0x00000031 = "0.31" */
    DWORD   dwFileFlagsMask;        /* = 0x3F for version "0.42" */
    DWORD   dwFileFlags;            /* e.g. VFF_DEBUG | VFF_PRERELEASE */
    DWORD   dwFileOS;               /* e.g. VOS_DOS_WINDOWS16 */
    DWORD   dwFileType;             /* e.g. VFT_DRIVER */
    DWORD   dwFileSubtype;          /* e.g. VFT2_DRV_KEYBOARD */
    DWORD   dwFileDateMS;           /* e.g. 0 */
    DWORD   dwFileDateLS;           /* e.g. 0 */
} VS_FIXEDFILEINFO;

/* ----- Function prototypes ----- */

DWORD
APIENTRY
VerFindFileA(
        DWORD uFlags,
        LPSTR szFileName,
        LPSTR szWinDir,
        LPSTR szAppDir,
        LPSTR szCurDir,
        PUINT lpuCurDirLen,
        LPSTR szDestDir,
        PUINT lpuDestDirLen
        );
DWORD
APIENTRY
VerFindFileW(
        DWORD uFlags,
        LPWSTR szFileName,
        LPWSTR szWinDir,
        LPWSTR szAppDir,
        LPWSTR szCurDir,
        PUINT lpuCurDirLen,
        LPWSTR szDestDir,
        PUINT lpuDestDirLen
        );
#ifdef UNICODE
#define VerFindFile  VerFindFileW
#else
#define VerFindFile  VerFindFileA
#endif // !UNICODE

DWORD
APIENTRY
VerInstallFileA(
        DWORD uFlags,
        LPSTR szSrcFileName,
        LPSTR szDestFileName,
        LPSTR szSrcDir,
        LPSTR szDestDir,
        LPSTR szCurDir,
        LPSTR szTmpFile,
        PUINT lpuTmpFileLen
        );
DWORD
APIENTRY
VerInstallFileW(
        DWORD uFlags,
        LPWSTR szSrcFileName,
        LPWSTR szDestFileName,
        LPWSTR szSrcDir,
        LPWSTR szDestDir,
        LPWSTR szCurDir,
        LPWSTR szTmpFile,
        PUINT lpuTmpFileLen
        );
#ifdef UNICODE
#define VerInstallFile  VerInstallFileW
#else
#define VerInstallFile  VerInstallFileA
#endif // !UNICODE

/* Returns size of version info in bytes */
DWORD
APIENTRY
GetFileVersionInfoSizeA(
        LPSTR lptstrFilename, /* Filename of version stamped file */
        LPDWORD lpdwHandle
        );                      /* Information for use by GetFileVersionInfo */
/* Returns size of version info in bytes */
DWORD
APIENTRY
GetFileVersionInfoSizeW(
        LPWSTR lptstrFilename, /* Filename of version stamped file */
        LPDWORD lpdwHandle
        );                      /* Information for use by GetFileVersionInfo */
#ifdef UNICODE
#define GetFileVersionInfoSize  GetFileVersionInfoSizeW
#else
#define GetFileVersionInfoSize  GetFileVersionInfoSizeA
#endif // !UNICODE

/* Read version info into buffer */
BOOL
APIENTRY
GetFileVersionInfoA(
        LPSTR lptstrFilename, /* Filename of version stamped file */
        DWORD dwHandle,         /* Information from GetFileVersionSize */
        DWORD dwLen,            /* Length of buffer for info */
        LPVOID lpData
        );                      /* Buffer to place the data structure */
/* Read version info into buffer */
BOOL
APIENTRY
GetFileVersionInfoW(
        LPWSTR lptstrFilename, /* Filename of version stamped file */
        DWORD dwHandle,         /* Information from GetFileVersionSize */
        DWORD dwLen,            /* Length of buffer for info */
        LPVOID lpData
        );                      /* Buffer to place the data structure */
#ifdef UNICODE
#define GetFileVersionInfo  GetFileVersionInfoW
#else
#define GetFileVersionInfo  GetFileVersionInfoA
#endif // !UNICODE

DWORD
APIENTRY
VerLanguageNameA(
        DWORD wLang,
        LPSTR szLang,
        DWORD nSize
        );
DWORD
APIENTRY
VerLanguageNameW(
        DWORD wLang,
        LPWSTR szLang,
        DWORD nSize
        );
#ifdef UNICODE
#define VerLanguageName  VerLanguageNameW
#else
#define VerLanguageName  VerLanguageNameA
#endif // !UNICODE

BOOL
APIENTRY
VerQueryValueA(
        const LPVOID pBlock,
        LPSTR lpSubBlock,
        LPVOID * lplpBuffer,
        PUINT puLen
        );
BOOL
APIENTRY
VerQueryValueW(
        const LPVOID pBlock,
        LPWSTR lpSubBlock,
        LPVOID * lplpBuffer,
        PUINT puLen
        );
#ifdef UNICODE
#define VerQueryValue  VerQueryValueW
#else
#define VerQueryValue  VerQueryValueA
#endif // !UNICODE

#endif  /* !RC_INVOKED */

#ifdef __cplusplus
}
#endif

#endif  /* !VER_H */
                                                                                                                                                                                                                                  �Z�����@
e6�xD"���¡R�?��y޽V�T꧃�޻_<�*զ�D�U�{eX� �����x�J�@� |�8;��� �w;��;"`��쉚B�Gc��c�s 4�t#���|]������lg _�����a�h�|Q����� �Q@b1�Q�N�7Z�'e�Y� ���0R@4#�������� 1�4�߰0����*�_���x^udB�Q�5��5�E�t,�,�<"�/�PC�w>��,��x�=Ǹ��M����������c��#5���#�$dQ��yQKx���?���ؗ�q�D�rP�D� %���!s�_\��[��E�q>'9�w�UP����z��mR�O	�p_
LD�W�V$R�U5ރ� �H�V�?��N�7G������<A�j�?�z:�<H��Y+�P�z��S ���&0[W�Ȓ�@Q�=jy�EZ�QC�U3 q޳���<A��˰�x]T����{&�7Gp<���(�җ�ߩ�
��?�ʏ
���9Sp�����;�+|CV^�Y�!��N]b��" ۙ���  .a�p" ��0�|��I����2�<���\� �"���"� �[  ���� ��b��� !�_U�r��5<|�۶�p����=7��Y���P���M�O��}�O�x~7���Mہ�w������U7���]%�S��~@DU8m�� ��7ޠ"���?�C�����������~}=��p�{n���8/z�FpP3S�A���wp��4� �P� �CK�`�d�7��@d�����	�	����
�dH��� �A�"�횈`5�K0 
�h.fl,��x64/ڬ���{�q�	E����|hB�X_��;"���&PMDD="��� "�0��?��v4X�c��rT."P������"���mP\��,��� ��X@0kȀ ��V�M0#@� �IY@��
V�� 
�Cā U,����Ȇz<D�a��s4Ύ�^=����X�	S�IT@O���8�C�sq��fE��w.�����^��r���	d�$����& �.� ~.氻Dy����
��;��  ��6���4�9�9���eu����8�|3�?Oiβ1L��o���Ȩ)N��2�. 0N+"H� � �Ѣ�x�.�D 7��Dx fW��c�H�P'��
��<�x�I
��:4��ӂ�4��x`���Ĺ���/�ng�!_Di *�E���	T�������<']\U��b�U+!Y����T��S�]o 	��� y
�n-�"���@`��eR�W��`J���"�W"�]+���bdN�8e��V\��+!gH:�0��C�q�m w�<3��hǸw!�^�ڲ"�)��L�it�W��x�v�~�rl���k��`@�c))�Q2&�Tӈ��2�˯vn�q6^��K�x��Ժ��~]��u�����a�.'�M�7��^�����l*%@���h�@@=k��<0=�Q�.����g
��+h0>��}��/������M0 !�6/��1Wa!�e��ؾq�=�7Ǹ�c�}_��B�g����2^=�%��e��K��ض����f���/� 0���T�7�͙n)�L���@�ř0ځG,˅j R��@�4 ��C�ZDStNi+Z0� �w����n�J力�L �$�!��g�
�U�=S�X@Ԥ_P��u2��+�"=�r��p��]���?N��@�W�������'e���^4b;b{�|
S$��P�	��7o��6sN=�t�3ݣ�w��� n��Cv�6F���g�o��G�Q�dG��"�<��� PA �   �@ ��  ��w
L�a�� ��b�H�^3]��0xL,��`@	<D�����!6?3�,�Ğ�Y���P�<��h D���PP{�f0��c:�A�������~�=������h��l��B���OZ/�JF������Fc7����`4������4�:f3��z������s��y��Dis��Y��Cs��A�O�t�}������ 9JN+��dq�>&[1��i��-��Q���:z��3g��7Z��Ƕ��q>'����|~_?�����~_������ 
� X� �*� �:�!J�!XZ�!�j�!�z�"�#�"X�'�"��+�"غ/�#�3�#X�7~�P �    �@`P8$�BaP�d6�DbQ8�V@���%�X! G���&�Ga�	a\@�		y�X0�I��A�|�0Pf2���X0
���<��h%
�:E�E(�:�f�Y�RJl�M`�ZmV�e��o�\`�B�H�/{���}�_0W�:�v�_�|]�v�dq�,�;	��b�X��%�������,�?�f�O��a��4���0H' @��?�� A���O���C�p,�PNG

   IHDR  ^  M   ^��y   gAMA  ���a   8tEXtSoftware XV Version 3.10a  Rev: 12/29/94 (PNG patch 1.2)�.I  �IDATx���	|����d�#�P� R#�	 ��� ��U���PT,R,rU.�A�V�@AQ@A%`-"Ac����r��I��fg�ٍ$��~�
�ٹ����yf&jRR��a���
  �����UU�-[��ŚE���]M��kw�vP3xLS$Fj�o���5�Y�G�t7��C��#i������o���h�(Mv-��ÿ���f�gJv]F#�l���џ��^�f{F�=��ڰ�񚑘Z2D4��4���� ����C׮]��o�>U��b1((�z��m۶���Q3�\�>g-?&4ӷ�f�4k��]��=#����&Y~pk�!��IV��S^��f�	t̗�d�M?5�O1�*�4�O��C�h/L������e�V���I�[�&5�f'Q4�U��6c7Jm�Ӝ|���,���̬��ZZ�.]��(�����sQU�^�֭[רQ#44TԎFk;��i�q��B��ҳO�~]��r�2I&��o�^��kv��cc���b�a��?D~��%�[��'H��Jm�Ogg�f�{�&�/3��o	2����f�.��|�u��r�"�R٥�]�@�7bi�rR߿����d��)h�.�؁J�2|�p}|xx��s�-ZԮ][��(*H��LJ:ؠ��oӶ��>u��OJD���"m��|,Y~�ɧ�E�)�;6�W+�޳��R{�]��I��@���|�MBr�m���3+�I��&}(��;�\7y�M�,���f?�IY�hyL�+T[�i~<ƪ�h,((��	
v�[T>�Rl
�^2��UcHHH�"b@����j������SI9�|����=����~1���m���/E���hԤ���|g�'��$p�:�a��,2��[���f��w��F�������k��9�yE�ce�����N`�ײ/0�b�~;Kw˧#�1�I�2�!*�٘h|�u>�w����ۦ*�B5]��ڃ]!��riJ�p��ŪF��%�E��z�x��;���o�7,�Az���;Ϝ�����N��z�x���ߛ�<wި���>}`͚5e*�c�|ȪƟ��{�YT�U���g�_��Ǚ�=�fQK���E-qU_����Z��^�E+�LϹ|͢yo�V�]�{~���s�>vfɗӢ�O�|�y�Ԡ�%��������Zzn��ؿ�|��_=�k�G����i�3�E5��f�m&���h�%��QմdP}����燝�Vy�ZL7��d�[�~A�	�Z���bz|J.D3x2}.G+1�j3ZT�`�^J���G������k�{�����?��72��R�O�n�~����~�U���\�[^,�&���&����n��Cis�svoӆŎ=�v���s�D.�H�����bz�p��族FGm�vgqPzJ��i�Z�fѬ[%�J��N?W�$�i��+(�0�?�3g�;��][yn���q����������ʸy����[��>�ş��*B�Q*Yj%?
�T}�5�a��/V���,�`Y��_������$�Bߏ��������BT�d���K�}Eq�R|���Xئ�.�c9��Q�0Q5���6��[6|����;?���o�g��opC�_e��i�k��9��ٍ�g�4]&��O4:��mJ�B7�j�r��u��$T4;9�E3�/,V���^GO��>^������>��>�9��>"���|m�S#bf���ΒO�=��"???���wm9p1;��-M~;6������kxM�ɯL?wa�o�}���7w���xцQF�m�q�^��Ѹ�P}}VV��[b��]�Uk��2�>�����b^͸����1��m-J���+z~C�qk�����ν�?���x4�Y<��7�b��Eݔm���{;7��6xG��EѬ������m:w���k��_b�ֹ���:����K;���ϛ��:��&��w����~��}��WQ4:�5;I`3���߾FG����vp���)<EwD��*D.��tk�趃F�Y������d�Y��n�Ӱ>�K7M�,~i����>Z�w�S��i^��#W�����L���-��}�Pj����o�g@��}^),g7���e�θ�싕m0.�4��z�Z�qa����IЪ2��i֚/Y��)�{#��������B��r���|��yӭ�z�F,���Rd��M7����۰���U�A"���ј���G�m=o��?0)��������������=[W�Q��/᳽�\�}s�ߊ)�6%::�dR~����.�~:�/����*9C��9Nn���sd�BXl�>�/OZ��s����������U����
����Æ���\����hh%W�m��Ԛu�}�pX<*�q��#��"//����W
��v��Tm��:)�m�bu��fs���u���7�����j�I�g{@���:N��K�/������QU��YJ�m�ߪ���T�Z����jfј���*Q�������q>G9�s��C/���^���@��B�{�2$f�Im۶M�޽�{�lT�e=���l�k��4�a`9k�-���!�r�^cRO�?�6�����Q�&O�g�KFڅ����w�v��x�V�jQѭE�X�W5o�l��P}%F`��\ T}[�i�h��H�#���9�RXc��^er���l�-�sYLP�ɣ�7I�{�̂���p����X�z�7/n�I/�bT\�hQ5�јr�h���s��N�9�Áܔ��o��(g��<%����/�$?e��F�M��9g�5 m�^#mM,Y��u�����7|�-)^S%<,�܅�����a��.��B.W�>�}���G���4�q:%��ty��s;>�_�j���i_l=���<���~��-�UgM�&ﻒ{�l.���~�gyɄ��e.�(��2 o���� �G}�I=�TC�N����W�e���sb�)�uJ�oflo�O JO��1//O��/??\�O��u�deg�8�w}d��3�WFc����4�bŤ5�D��R�(�h�J�OU�}��n��3H�RY�� 6�m���xv�W�{dɾ��nز>�M_w�����kQ�j5��MM>נq���/�r׀����`傏��.�T��9,:_��a�kk=1���!��^����-«��ר|�\�H��K6�";����g�)�=�Uw��xgsY֦�]��h�|4�t�X��C�����>�&v�5{W�ݳ���ѥZ�3w�2�Ӟ�����k�����u��KG�\JA�&U56|2����M���O��Ѳ2����l%�R�����������\ir�h�\M���a�d5�f��\n���U1�p��@�}T�?�f�y�b;=�9M���߹��+o�d�׃��Iؑ�ف��x�6�ၿ��=�h��}�}� ������>sEd֮W=;+��݇f�9�Y�1�:ƿ���>yb�]=~������k��~F��T6y-J1�40�4��.��C��\ƍ����)�W8�Tx��xE1X�f1^2���= Y������rU%����i+�E��ݑ�����s��E�%�F�Kq q[qU�3,,L�����w5�}��&�ł�E������IV*UQj7RNݣ�΢Ѵ�I>�~�[�^�v��g�f`�+H��8:�֗ �� ���fI#��k}�;��v�hwO�ųӄv֖ky@dg4.�e.��o�Ul���5�ھ!�ɑ�[����.�ᐛ������o��'��AU����oĭR7�B���Q؈���4��p ?9R�,�9rd�F�m6��~�h�x���,vPh����zpeZ���w�����&�;%����J�G�T�Y5���*�.I���%�f'6|ߗ�t3T�-TL��7�F1=�U3��U�J]ݯY���r��R���pD�<�����_���jɧs/*�9��[����V�ݻ����˗��h�~ِ��|�6�w-���$h���X�����cbt@��O����B�u�gˤ�u�������&�i~>�f�3]���2<dn; s��L�����S��dW����ͭ+U�^I�k%=�$��hA���\��F=Ř�nݤQ=n��g�F'3�^�kK���6Rͯ�ѯ�n��y���V�ʯ�Qx���
;�ř�fX���o�e9k��2m���L�g~�8��g���}	4�J������5�@�@5??WSM��