package com.takwolf.android.materialdesign.color.docgetter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {
        // xml头部
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb.append("<resources>\n");
        sb.append("\n");
        sb.append("    <!-- Update at ").append(LocalDate.now().toString()).append(" -->\n");
        sb.append("\n");

        // 抓取目标文档
        Document document = Jsoup.connect("https://material.io/guidelines/style/color.html").timeout(40000).get();

        // 解析调色板
        Elements colorPalettes = document.getElementsByClass("color-palette");
        for (Element colorPalette : colorPalettes) {
            Elements colorGroups = colorPalette.getElementsByClass("color-group");
            for (Element colorGroup : colorGroups) {
                Element colorGroupUl = colorGroup.child(0);
                Element mainColor = colorGroupUl.child(0);
                if (mainColor.hasClass("main-color")) {
                    Element colorName = mainColor.child(0);
                    sb.append("    <!-- ").append(colorName.text()).append(" -->\n");
                    sb.append("    <color name=\"material_").append(colorName.text().replace(" ", "_").toLowerCase()).append("\">").append(mainColor.child(2).text()).append("</color>\n");
                    mainColor.remove();
                    for (Element li : colorGroupUl.children()) {
                        String name = ("material_" + colorName.text().replace(" ", "_") + "_" + li.child(0).text()).toLowerCase();
                        String value = li.child(1).text().toLowerCase();
                        sb.append("    <color name=\"").append(name).append("\">").append(value).append("</color>\n");
                    }
                } else {
                    sb.append("    <!-- Black and White -->\n");
                    for (Element li : colorGroupUl.children()) {
                        String name = ("material_" + li.child(0).text()).toLowerCase();
                        String value = li.child(1).text().toLowerCase();
                        sb.append("    <color name=\"").append(name).append("\">").append(value).append("</color>\n");
                    }
                    sb.append("    <color name=\"material_transparent\">#00000000</color>\n");
                }
                sb.append("\n");
            }
        }

        // 文字和背景颜色
        sb.append("    <!-- Text, Icons and other elements -->\n");
        sb.append("    <!-- Dark -->\n");
        sb.append("    <color name=\"material_dark_text_primary\">").append(String.format("#%x000000", Math.round(0.87f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_dark_text_secondary\">").append(String.format("#%x000000", Math.round(0.54f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_dark_text_disabled\">").append(String.format("#%x000000", Math.round(0.38f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_dark_text_hint\">").append(String.format("#%x000000", Math.round(0.38f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_dark_divider\">").append(String.format("#%x000000", Math.round(0.12f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_dark_icon\">").append(String.format("#%x000000", Math.round(0.54f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_dark_icon_disabled\">").append(String.format("#%x000000", Math.round(0.38f * 255))).append("</color>\n");
        sb.append("    <!-- Light -->\n");
        sb.append("    <color name=\"material_light_text_primary\">").append(String.format("#%xffffff", Math.round(1.0f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_light_text_secondary\">").append(String.format("#%xffffff", Math.round(0.7f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_light_text_disabled\">").append(String.format("#%xffffff", Math.round(0.5f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_light_text_hint\">").append(String.format("#%xffffff", Math.round(0.5f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_light_divider\">").append(String.format("#%xffffff", Math.round(0.12f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_light_icon\">").append(String.format("#%xffffff", Math.round(1.0f * 255))).append("</color>\n");
        sb.append("    <color name=\"material_light_icon_disabled\">").append(String.format("#%xffffff", Math.round(0.5f * 255))).append("</color>\n");
        sb.append("\n");

        // xml结尾
        sb.append("</resources>\n");

        // 写入文件
        File file = new File("color/src/main/res/values/colors.xml");
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            //noinspection ResultOfMethodCallIgnored
            parentFile.mkdirs();
        }
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        writer.println(sb.toString());
        writer.flush();
        writer.close();
    }

}
