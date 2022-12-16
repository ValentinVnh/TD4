package Gestion_transactionnelles_E_commerce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
public class Dataset {

    private static Dataset singleton;
    private final Collection<Transaction> transactions;
    private final Article[] articles;

    private Dataset() throws IOException {
        System.out.println("Test");
        this.articles = new Article[130];
        for (int i=0;i<articles.length;i++){
            articles[i] = new Article("",0);
        }

        transactions = new ArrayList<Transaction>();
        BufferedReader reader = new BufferedReader(new FileReader("ecommerceProxyEtud/data/ecommerce.txt"));
        String line;
        while(((line = reader.readLine()) != null)){
            if(line.isEmpty() || line.charAt(0) == '#' || line.charAt(0) == '%' || line.charAt(0) == '@'){
                continue;
            }
            String[] lineSplited = line.split(" ");
            Transaction transaction = new Transaction();
            for (String s : lineSplited) {
                int item = Integer.parseInt(s);
                transaction.add(articles[item]);
            }
            transactions.add(transaction);
        }
        reader.close();
    }

    public static Dataset getInstance() throws IOException {
        if (singleton == null) singleton = new Dataset();
        return null;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public Article[] getArticles() {
        return articles;
    }

}
