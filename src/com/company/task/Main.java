package com.company.task;

public class Main {

    public static void main(String[] args) {
	    szukaj("input.txt", "output.txt", "egzamin");
    }

    public static void szukaj(String nazwaPlikWe, String nazwaPlikWy, String słowo) {
        String content = FileUtils.getContent(nazwaPlikWe);
        String[] lines = getAsLines(content);

        StringBuilder output = new StringBuilder();
        for(int i=0;i<lines.length;i++) {
            String line = lines[i];
            if(line.contains(słowo)) {
                if(output.length() == 0){
                    output.append(i+1).append(": ").append(line);
                } else {
                    output.append("\n").append(i+1).append(": ").append(line);
                }
            }
        }

        FileUtils.setContent(nazwaPlikWy, output.toString());
    }

    private static String[] getAsLines(String content) {
        return content.split("\\r?\\n");
    }

}
