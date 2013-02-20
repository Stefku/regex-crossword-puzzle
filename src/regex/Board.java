package regex;

import java.util.HashMap;
import java.util.Map;

public class Board {

    public enum Segment {A, B, C, D, E, F}

    private int sideLength = 2;

    private int diameter = 3;
    private char[][] board = new char[3][3];

    private Map<Segment, Map<Integer, String>> expressions = new HashMap<>();

    public void setExpression(Segment segment, int segmentNo, String expression) {
        if (!expressions.containsKey(segment)) {
            expressions.put(segment, new HashMap<Integer, String>());
        }
        expressions.get(segment).put(segmentNo, expression);
    }

    public void setCharacter(int x, int y, char character) {
        board[x][y] = character;
    }

    public String getString(Segment segment, int segmentNo) {
        switch (segment) {
            case A:
                return getStringForSegmentA(segmentNo);
            case B:
                return getStringForSegmentB(segmentNo);
            case C:
                return getStringForSegmentC(segmentNo);
            case D:
                return getStringForSegmentD(segmentNo);
            case E:
                return getStringForSegmentE(segmentNo);
            case F:
                return getStringForSegmentF(segmentNo);
        }
        throw new IllegalArgumentException();
    }

    private String getStringForSegmentA(int segmentNo) {
        int offset = 0;
        int y = segmentNo;
        StringBuilder sb = new StringBuilder(diameter);
        for (int x = offset; x < sideLength + y - offset; x++) {
            sb.append(board[x][y]);
        }
        return sb.toString();
    }

    private String getStringForSegmentB(int segmentNo) {
        int y = sideLength + segmentNo;
        int offset = 1;
        StringBuilder sb = new StringBuilder(diameter);
        for (int x = offset; x < sideLength + y - offset; x++) {
            sb.append(board[x][y]);
        }
        return sb.toString();
    }

    private String getStringForSegmentC(int segmentNo) {
        int lastXB = sideLength - 1;
        int lastYB = diameter - 1;

        int x = lastXB + segmentNo;
        int y = lastYB;

        StringBuilder sb = new StringBuilder(diameter);
        while (x >= 0) {
            sb.append(board[x][y]);
            x -= 1;
            y -= 1;
        }

        return sb.toString();
    }

    private String getStringForSegmentD(int segmentNo) {
        int x = diameter - 1;
        int y = diameter - 1 - (segmentNo + 1);

        StringBuilder sb = new StringBuilder(diameter);
        while (y >= 0) {
            sb.append(board[x][y]);
            x -= 1;
            y -= 1;
        }

        return sb.toString();
    }

    private String getStringForSegmentE(int segmentNo) {
        int x = diameter - 1 - segmentNo;
        int y = sideLength - 1 - segmentNo;

        StringBuilder sb = new StringBuilder(diameter);
        while (y <= diameter - 1) {
            sb.append(board[x][y]);
            y += 1;
        }

        return sb.toString();
    }

    private String getStringForSegmentF(int segmentNo) {
        int x = sideLength - 1 - 1;
        int y = 0;

        StringBuilder sb = new StringBuilder(diameter);
        while (y <= diameter - 1 - (segmentNo + 1)) {
            sb.append(board[x][y]);
            y += 1;
        }

        return sb.toString();
    }
}
