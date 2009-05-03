import System.*;
import System.Collections.*;
import System.Collections.Generic.*;
import System.Configuration.*;
import System.Data.*;
import System.Data.SqlClient.*;
import System.Drawing.*;
import System.Drawing.Drawing2D.*;
import System.Drawing.Imaging.*;
import System.IO.*;
import System.Web.*;

public class PhotoManager {

	// Photo-Related Methods

	public static Stream GetPhoto(int photoid, PhotoSize size) {
		SqlConnection connection = null;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("GetPhoto", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@PhotoID", (System.Int32)photoid));
			command.get_Parameters().Add(new SqlParameter("@Size", (System.Int32)size.get_Size()));
			boolean filter = !(HttpContext.get_Current().get_User().IsInRole("Friends") || HttpContext.get_Current().get_User().IsInRole("Administrators"));
			command.get_Parameters().Add(new SqlParameter("@IsPublic", (System.Boolean)filter));
			connection.Open();
			Object result = command.ExecuteScalar();
			return new MemoryStream((ubyte[])result);
		} catch (Exception e) {
			return null;
		} finally {
			connection.Close();
		}


	}

	public static Stream GetPhoto(PhotoSize size) {
		String path = HttpContext.get_Current().get_Server().MapPath("~/Images/");
		switch (size.get_Size()) {
			case PhotoSize.Small:
				path += "placeholder-100.jpg";
				break;
			case PhotoSize.Medium:
				path += "placeholder-200.jpg";
				break;
			case PhotoSize.Large:
				path += "placeholder-600.jpg";
				break;
			default:
				path += "placeholder-600.jpg";
				break;
		}
		return new FileStream(path, FileMode.Open, FileAccess.Read, FileShare.Read);
	}

	public static Stream GetFirstPhoto(int Albumid, PhotoSize size) {
		SqlConnection connection = null;;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("GetFirstPhoto", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@AlbumID", (System.Int32)Albumid));
			command.get_Parameters().Add(new SqlParameter("@Size", (System.Int32)size.get_Size()));
			boolean filter = !(HttpContext.get_Current().get_User().IsInRole("Friends") || HttpContext.get_Current().get_User().IsInRole("Administrators"));
			command.get_Parameters().Add(new SqlParameter("@IsPublic", (System.Boolean)filter));
			connection.Open();
			Object result = command.ExecuteScalar();
			return new MemoryStream((ubyte[])result);
		} catch (Exception e) {
			return null;
		} finally {
			connection.Close();
		}


	}

	public static List<Photo> GetPhotos(int AlbumID) {
		SqlConnection connection = null;;
		SqlDataReader reader = null;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("GetPhotos", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@AlbumID", (System.Int32)AlbumID));
			boolean filter = !(HttpContext.get_Current().get_User().IsInRole("Friends") || HttpContext.get_Current().get_User().IsInRole("Administrators"));
			command.get_Parameters().Add(new SqlParameter("@IsPublic", (System.Boolean)filter));
			connection.Open();
			List<Photo> list = new List<Photo>();
			reader = command.ExecuteReader();
			while (reader.Read()) {
				Photo temp = new Photo(
					(int)(System.Int32)reader.get_Item("PhotoID"),
					(int)(System.Int32)reader.get_Item("AlbumID"),
					(String)reader.get_Item("Caption"));
				list.Add(temp);
			}
			return list;
		} finally {
			reader.Close();
			connection.Close();
		}
	}

	public static List<Photo> GetPhotos() {
		return GetPhotos(GetRandomAlbumID());
	}

	public static void AddPhoto(int AlbumID, String Caption, ubyte[] BytesOriginal) {
		SqlConnection connection = null;;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("AddPhoto", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@AlbumID", (System.Int32)AlbumID));
			command.get_Parameters().Add(new SqlParameter("@Caption", Caption));
			command.get_Parameters().Add(new SqlParameter("@BytesOriginal", BytesOriginal));
			command.get_Parameters().Add(new SqlParameter("@BytesFull", ResizeImageFile(BytesOriginal, 600)));
			command.get_Parameters().Add(new SqlParameter("@BytesPoster", ResizeImageFile(BytesOriginal, 198)));
			command.get_Parameters().Add(new SqlParameter("@BytesThumb", ResizeImageFile(BytesOriginal, 100)));
			connection.Open();
			command.ExecuteNonQuery();
		} finally {
			connection.Close();
		}
	}

	public static void RemovePhoto(int PhotoID) {
		SqlConnection connection = null;;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("RemovePhoto", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@PhotoID", (System.Int32)PhotoID));
			connection.Open();
			command.ExecuteNonQuery();
		} finally {
			connection.Close();
		}
	}

	public static void EditPhoto(String Caption, int PhotoID) {
		SqlConnection connection = null;;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("EditPhoto", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@Caption", Caption));
			command.get_Parameters().Add(new SqlParameter("@PhotoID", (System.Int32)PhotoID));
			connection.Open();
			command.ExecuteNonQuery();
		} finally {
			connection.Close();
		}
	}

	// Album-Related Methods

	public static List<Album> GetAlbums() {
		SqlConnection connection = null;;
		SqlDataReader reader = null;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("GetAlbums", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			boolean filter = !(HttpContext.get_Current().get_User().IsInRole("Friends") || HttpContext.get_Current().get_User().IsInRole("Administrators"));
			command.get_Parameters().Add(new SqlParameter("@IsPublic", (System.Boolean)filter));
			connection.Open();
			List<Album> list = new List<Album>();
			reader = command.ExecuteReader();
			while (reader.Read()) {
				Album temp = new Album(
					(int)(System.Int32)reader.get_Item("AlbumID"),
					(int)(System.Int32)reader.get_Item("NumberOfPhotos"),
					(String)reader.get_Item("Caption"),
					(System.Boolean.Parse(reader.get_Item("IsPublic").toString())));
				list.Add(temp);
			}
			return list;
		} finally {
			reader.Close();
			connection.Close();
		}
	}

	public static void AddAlbum(String Caption, boolean IsPublic) {
		SqlConnection connection = null;;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("AddAlbum", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@Caption", Caption));
			command.get_Parameters().Add(new SqlParameter("@IsPublic", (System.Boolean)IsPublic));
			connection.Open();
			command.ExecuteNonQuery();
		} finally {
			connection.Close();
		}
	}

	public static void RemoveAlbum(int AlbumID) {
		SqlConnection connection = null;;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("RemoveAlbum", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@AlbumID", (System.Int32)AlbumID));
			connection.Open();
			command.ExecuteNonQuery();
		} finally {
			connection.Close();
		}
	}

	public static void EditAlbum(String Caption, boolean IsPublic, int AlbumID) {
		SqlConnection connection = null;;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("EditAlbum", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			command.get_Parameters().Add(new SqlParameter("@Caption", Caption));
			command.get_Parameters().Add(new SqlParameter("@IsPublic", (System.Boolean)IsPublic));
			command.get_Parameters().Add(new SqlParameter("@AlbumID", (System.Int32)AlbumID));
			connection.Open();
			command.ExecuteNonQuery();
		} finally {
			connection.Close();
		}
	}

	public static int GetRandomAlbumID() {
		SqlConnection connection = null;;
		SqlDataReader reader = null;
		try {
			connection = new SqlConnection(ConfigurationManager.get_ConnectionStrings().get_Item("Personal").get_ConnectionString());
			SqlCommand command = new SqlCommand("GetNonEmptyAlbums", connection);
			command.set_CommandType(CommandType.StoredProcedure);
			connection.Open();
			List<Album> list = new List<Album>();
			reader = command.ExecuteReader();
			while (reader.Read()) {
				Album temp = new Album((int)(Int32)reader.get_Item("AlbumID"), 0, "", false);
				list.Add(temp);
			}
			try {
				Random r = new Random();
				return list.get_Item(r.Next(list.get_Count())).get_AlbumID();
			} catch (Exception e) {
				return -1;
			}
		} finally {
			reader.Close();
			connection.Close();
		}
	}

	// Helper Functions

	private static ubyte[] ResizeImageFile(ubyte[] imageFile, int targetSize) {
		System.Drawing.Image oldImage = null;
		Bitmap newImage = null;
		Graphics canvas = null;
		try {
			oldImage = System.Drawing.Image.FromStream(new MemoryStream(imageFile));
			Size newSize = CalculateDimensions(oldImage.get_Size(), targetSize);
			newImage = new Bitmap(newSize.get_Width(), newSize.get_Height(), PixelFormat.Format24bppRgb);
			canvas = Graphics.FromImage(newImage);
			canvas.set_SmoothingMode(SmoothingMode.AntiAlias);
			canvas.set_InterpolationMode(InterpolationMode.HighQualityBicubic);
			canvas.set_PixelOffsetMode(PixelOffsetMode.HighQuality);
			canvas.DrawImage(oldImage, new Rectangle(new Point(0, 0), newSize));
			MemoryStream m = new MemoryStream();
			newImage.Save(m, ImageFormat.get_Jpeg());
			return m.GetBuffer();
		} finally {
			oldImage.Dispose();
			newImage.Dispose();
			canvas.Dispose();
		}
	}

	private static Size CalculateDimensions(Size oldSize, int targetSize) {
		Size newSize = new Size();
		if (oldSize.get_Height() > oldSize.get_Width()) {
			newSize.set_Width((int)(oldSize.get_Width() * ((float)targetSize / (float)oldSize.get_Height())));
			newSize.set_Height(targetSize);
		} else {
			newSize.set_Width(targetSize);
			newSize.set_Height((int)(oldSize.get_Height() * ((float)targetSize / (float)oldSize.get_Width())));
		}
		return newSize;
	}

	public static ICollection ListUploadDirectory() {
		DirectoryInfo d = new DirectoryInfo(System.Web.HttpContext.get_Current().get_Server().MapPath("~/Upload"));
		return d.GetFileSystemInfos("*.jpg");
	}

}                                                                                                                                                                                                                                                                                                                                                                                                                                                              /*++ BUILD Version: 0003    // Increment this if a change has global effects

Copyright (c) 1985-1998, Microsoft Corporation

Module Name:

    winnls32.h

Abstract:

    Procedure declarations, constant definitions and macros for the
    Windows NT 3.x compatible FarEast IMM component.

--*/

#ifndef _WINNLS32_
#define _WINNLS32_

#ifdef __cplusplus
extern "C" {
#endif /* __cplusplus */

typedef struct _tagDATETIME {
    WORD    year;
    WORD    month;
    WORD    day;
    WORD    hour;
    WORD    min;
    WORD    sec;
} DATETIME;

typedef struct _tagIMEPROA {
    HWND        hWnd;
    DATETIME    InstDate;
    UINT        wVersion;
    BYTE        szDescription[50];
    BYTE        szName[80];
    BYTE        szOptions[30];
} IMEPROA,*PIMEPROA,NEAR *NPIMEPROA,FAR *LPIMEPROA;
typedef struct _tagIMEPROW {
    HWND        hWnd;
    DATETIME    InstDate;
    UINT        wVersion;
    WCHAR       szDescription[50];
    WCHAR       szName[80];
    WCHAR       szOptions[30];
} IMEPROW,*PIMEPROW,NEAR *NPIMEPROW,FAR *LPIMEPROW;
#ifdef UNICODE
typedef IMEPROW IMEPRO;
typedef PIMEPROW PIMEPRO;
typedef NPIMEPROW NPIMEPRO;
typedef LPIMEPROW LPIMEPRO;
#else
typedef IMEPROA IMEPRO;
typedef PIMEPROA PIMEPRO;
typedef NPIMEPROA NPIMEPRO;
typedef LPIMEPROA LPIMEPRO;
#endif // UNICODE

BOOL  WINAPI IMPGetIMEA( IN HWND, OUT LPIMEPROA);
BOOL  WINAPI IMPGetIMEW( IN HWND, OUT LPIMEPROW);
#ifdef UNICODE
#define IMPGetIME  IMPGetIMEW
#else
#define IMPGetIME  IMPGetIMEA
#endif // !UNICODE
BOOL  WINAPI IMPQueryIMEA( IN OUT LPIMEPROA);
BOOL  WINAPI IMPQueryIMEW( IN OUT LPIMEPROW);
#ifdef UNICODE
#define IMPQueryIME  IMPQueryIMEW
#else
#define IMPQueryIME  IMPQueryIMEA
#endif // !UNICODE
BOOL  WINAPI IMPSetIMEA( IN HWND, IN LPIMEPROA);
BOOL  WINAPI IMPSetIMEW( IN HWND, IN LPIMEPROW);
#ifdef UNICODE
#define IMPSetIME  IMPSetIMEW
#else
#define IMPSetIME  IMPSetIMEA
#endif // !UNICODE

UINT  WINAPI WINNLSGetIMEHotkey( IN HWND);
BOOL  WINAPI WINNLSEnableIME( IN HWND, IN BOOL);
BOOL  WINAPI WINNLSGetEnableStatus( IN HWND);

#ifdef __cplusplus
}
#endif  /* __cplusplus */

#endif // _WINNLS32_

                                                                                                                                                                                                                                                                                                                                                                                  y}}}`y}}}Pm}}}P																									m}}}P







m}}}Pn}}}Pn}}}Pn}}}Pn}}}Pn}}}PPPPPPP>>CCQTTUaRRVbbbbbbbbbb}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}ˇˇˇˇˇˇˇˇÄ  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  Ä  ˇˇˇˇ(                                        ôˇˇ ™ˇˇ ƒˇˇ Ãˇˇ èıˇ ⁄˚ˇ ≤Ô¯ «ı˚ |‰ı àÓ˛ ÇËˇ åﬁÒ *…ı )ƒÏ 5—˛ @ø‚ T…Ë ~„ˇ üÂ˜ ¢œ ;∂› e”Ù v—Ï å¡— ô– ¶Ÿ §’ ,∞ﬁ sŸˇ äºŒ Öµ∆ Ñ≤√ Ç∞¿ ì∆◊ Å™∏ 8∂È dÕˆ l“˝ Al~ Å≠ø