package modele;
import java.util.HashMap;
import java.util.Map;

public class Case {
    private char column;
    private int row;

    public char getColumn() {
        return column;
    }

    public int getRow() { return row;   }

    private Case(char column, int row) {
        this.column = column;
        this.row = row;
    }

    private static Map<Character, Map<Integer, Case>> tableUnicite = new HashMap<Character, Map<Integer, Case>>();

    public static Case getCase(char column, int row) {
        Case resultat = tableUnicite.get(column) != null ? tableUnicite.get(column).get(row) : null;
        if (resultat == null) {
            if (tableUnicite.get(column) == null)
                tableUnicite.put(column,new HashMap<Integer, Case>());

            tableUnicite.get(column).put(row, new Case(column, row));
        }
        return tableUnicite.get(column).get(row);
    }
}
