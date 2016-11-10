package com.sye;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MarkdownGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.sye.seeing.dao");
        addMarkdownNote(schema);
        new DaoGenerator().generateAll(schema, "app/src/main/java-gen");
    }
    /**
     * the entry of markdown note
     *com/sye/MarkdownGenerator.java:10
     * @param schema
     */
    private static void addMarkdownNote(Schema schema) {
        Entity entity = schema.addEntity("Markdown");
        entity.addIdProperty().primaryKey().autoincrement();//primary key and auto increment
        entity.addStringProperty("title");
        entity.addLongProperty("createTime");
        entity.addLongProperty("lastTime");
        entity.addStringProperty("content");
        entity.addStringProperty("localPath");
        entity.addLongProperty("size");
    }
}
