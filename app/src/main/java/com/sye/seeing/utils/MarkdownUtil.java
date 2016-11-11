package com.sye.seeing.utils;

/**
 * @author Secray
 * @date 2016.11.11
 * Deal with some string action for markdown tools
 */
public class MarkdownUtil {
    private static final String HEADER = "| header ";
    private static final String DIVIDER = "|:------:";
    private static final String CONTENT = "|        ";
    public static String getLinkAction(String display, String url) {
        return "\n[" + display + "](" + url + ")";
    }

    public static String getTableAction(String row, String column) {
        return "\n\n"+ getHeader(row) + getDivider(row) + getContent(row, column);
    }

    public static String getImageAction(String imagePath) {
        return "\n![image](" + imagePath + ")";
    }

    private static String getHeader(String rowString) {
        return parseTableItem(rowString, HEADER);
    }

    private static String getDivider(String rowString) {
        return parseTableItem(rowString, DIVIDER);
    }

    private static String getContent(String rowString, String columnString) {
        int column = columnString == null ? 0 : Integer.parseInt(columnString);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < column; i ++) {
            sb.append(parseTableItem(rowString, CONTENT));
        }
        return sb.toString();
    }

    private static String parseTableItem(String rowString, String item) {
        int row = rowString == null ? 0 : Integer.parseInt(rowString);
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < row ; i ++) {
            sb.append(item);
        }
        sb.append("|\n");
        return sb.toString();
    }
}
