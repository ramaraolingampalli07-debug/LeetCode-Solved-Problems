class Solution {
    public java.util.List<String> braceExpansionII(String expression) {
        java.util.TreeSet<String> set = new java.util.TreeSet<>();
        int closingBraceIdx = expression.indexOf('}');
        if (closingBraceIdx == -1) {
            set.add(expression);
            return new java.util.ArrayList<>(set);
        }
        int openingBraceIdx = expression.lastIndexOf('{', closingBraceIdx);
        String prefix = expression.substring(0, openingBraceIdx);
        String suffix = expression.substring(closingBraceIdx + 1);
        String[] options = expression.substring(openingBraceIdx + 1, closingBraceIdx).split(",");
        for (String option : options) {
            set.addAll(braceExpansionII(prefix + option + suffix));
        }
        return new java.util.ArrayList<>(set);
    }
}
