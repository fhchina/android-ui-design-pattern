package com.mathieucalba.yana.provider;

import android.net.Uri;


public class YANAContract {

	public static String CONTENT_AUTHORITY = "com.mathieucalba.yana.provider";
	protected static Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
	protected static String VENDOR_NAME = "vnd.mathieucalba.yana";

	protected static final String PATH_ARTICLE = "article";
	protected static final String PATH_TYPE = "type";

	public interface Tables {
		static final String ARTICLE = "ARTICLE";
	}

	public interface StandardColumns {
		/** Default Column _ID */
		public static final String _ID = "_id";
	}

	public interface ArticleColumns {
		/** Default Column _ID */
		/** Primary key id (INTEGER) */
		static final String ID = "id";
		/** Title (TEXT) */
		static final String TITLE = "title";
		/** Image URL (TEXT) */
		static final String IMAGE_URL = "image_url";
		/** Header (TEXT) */
		static final String HEADER = "header";
		/** Content (TEXT) */
		static final String CONTENT = "content";
		/** Author (TEXT) */
		static final String AUTHOR = "author";
		/** Type (INTEGER) */
		static final String TYPE = "type";
		/** Timestamp (INTEGER) */
		static final String TIMESTAMP = "timestamp";
	}

	/**
	 * Articles
	 */
	public static class ArticleTable implements StandardColumns, ArticleColumns {

		public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_ARTICLE).build();

		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/" + VENDOR_NAME + "." + PATH_ARTICLE;
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/" + VENDOR_NAME + "." + PATH_ARTICLE;

		/** Default "ORDER BY" clause. */
		public static final String DEFAULT_SORT = Tables.ARTICLE + "." + ArticleColumns.TIMESTAMP + " DESC";

		public static final class ARTICLE_TYPE {
			public static final int NEWS = 1;
			public static final int BRIEF = 2;
			public static final int TEST = 3;
			public static final int REPORT = 4;
		}

		public static class PROJ_DETAIL {
			public static int _ID = 0;
			public static int ID = 1;
			public static int TITLE = 2;
			public static int IMAGE_URL = 3;
			public static int HEADER = 4;
			public static int CONTENT = 5;
			public static int AUTHOR = 6;
			public static int TYPE = 7;
			public static int TIMESTAMP = 8;

			public static String[] COLS = new String[] { //
				StandardColumns._ID, //
				Tables.ARTICLE + "." + ArticleColumns.ID, //
				Tables.ARTICLE + "." + ArticleColumns.TITLE, //
				Tables.ARTICLE + "." + ArticleColumns.IMAGE_URL, //
				Tables.ARTICLE + "." + ArticleColumns.HEADER, //
				Tables.ARTICLE + "." + ArticleColumns.CONTENT, //
				Tables.ARTICLE + "." + ArticleColumns.AUTHOR, //
				Tables.ARTICLE + "." + ArticleColumns.TYPE, //
				Tables.ARTICLE + "." + ArticleColumns.TIMESTAMP //
			};
		}

		public static class PROJ_LIST {
			public static int _ID = 0;
			public static int ID = 1;
			public static int TITLE = 2;
			public static int IMAGE_URL = 3;
			public static int HEADER = 4;
			public static int TYPE = 5;
			public static int TIMESTAMP = 6;

			public static String[] COLS = new String[] { //
				StandardColumns._ID, //
				Tables.ARTICLE + "." + ArticleColumns.ID, //
				Tables.ARTICLE + "." + ArticleColumns.TITLE, //
				Tables.ARTICLE + "." + ArticleColumns.IMAGE_URL, //
				Tables.ARTICLE + "." + ArticleColumns.HEADER, //
				Tables.ARTICLE + "." + ArticleColumns.TYPE, //
				Tables.ARTICLE + "." + ArticleColumns.TIMESTAMP //
			};
		}

		/** Build URI for all articles */
		public static Uri buildUri() {
			return CONTENT_URI.buildUpon().appendPath(PATH_ARTICLE).build();
		}

		/** Build URI for all article with type */
		public static Uri buildUriWithType(int type) {
			return CONTENT_URI.buildUpon().appendPath(PATH_ARTICLE).appendPath(PATH_TYPE).appendPath(String.valueOf(type)).build();
		}

		/** Build URI for all news */
		public static Uri buildUriNews() {
			return buildUriWithType(ARTICLE_TYPE.NEWS);
		}

		/** Build URI for all briefs */
		public static Uri buildUriBriefs() {
			return buildUriWithType(ARTICLE_TYPE.BRIEF);
		}

		/** Build URI for all tests */
		public static Uri buildUriTests() {
			return buildUriWithType(ARTICLE_TYPE.TEST);
		}

		/** Build URI for all reports */
		public static Uri buildUriReports() {
			return buildUriWithType(ARTICLE_TYPE.REPORT);
		}

		/** Build URI for one article */
		public static Uri buildUriWithId(int id) {
			return CONTENT_URI.buildUpon().appendPath(PATH_ARTICLE).appendPath(String.valueOf(id)).build();
		}

		public static String getType(Uri uri) {
			return uri.getPathSegments().get(3);
		}

		public static String getId(Uri uri) {
			return uri.getPathSegments().get(2);
		}

	}

}