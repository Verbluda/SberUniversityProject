package Homework_2_Profile_module.Task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentsInOrder {
    private DocumentsInOrder() {}
    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();
        documents.add(new Document(897, "Документ 1", 567));
        documents.add(new Document(898, "Документ 2", 472));
        System.out.println(documents);
        System.out.println(organizeDocuments(documents));
    }
    public static Map<Integer, Document> organizeDocuments(List<Document> documents) {
        Map<Integer, Document> documentsInOrder = new HashMap<>();
        for (Document d: documents) {
            documentsInOrder.put(d.getId(), d);
        }
        return documentsInOrder;
    }
}
