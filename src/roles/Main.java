package roles;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 28.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
        "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
        "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!",
        "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        java.util.Map<String, java.lang.StringBuilder> rolesToLines = new java.util.HashMap<String, java.lang.StringBuilder>();
        for (String role: roles){
            rolesToLines.put(role, new StringBuilder(role).append(":"));
        }

        int counter = 1;
        for(String textLine: textLines){
            int colonIndex = textLine.indexOf(':');
            String first = textLine.substring(0, colonIndex);
            String second = textLine.substring(colonIndex  + 2);
            rolesToLines.put(first, rolesToLines.get(first).append("\n").append(counter).append(") ").append(second));
            counter++;
        }

        String allRolesAndTexts = "";
        for (String s: roles){
            allRolesAndTexts = allRolesAndTexts + rolesToLines.get(s).append("\n\n");
        }
        return allRolesAndTexts;
    }
}
