package Gestion_transactionnelles_E_commerce;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 *
 */
public class Motif extends Transaction implements IMotif {


    public Motif() {

        super();

    }

    public boolean isFreq() throws IOException {
        return freq() >= 0.5;
    }


    public float freq() throws IOException {
        Collection<Transaction> transactions = Dataset.getInstance().getTransactions();
        float freq = 0;
        for (Transaction t : transactions) {
            if (match(t)) {
                freq++;
            }
        }
        return freq / transactions.size();
    }


    public boolean match(Transaction transaction) {
        return new HashSet<>(transaction.acticles).containsAll(acticles);
    }
}