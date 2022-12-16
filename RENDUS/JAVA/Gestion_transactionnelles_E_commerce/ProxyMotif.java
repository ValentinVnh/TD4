package Gestion_transactionnelles_E_commerce;
import java.io.IOException;
import java.util.*;

/**
 *
 */
public class ProxyMotif {
    private final Motif motif;
    private static final Map<Motif, Boolean> cache = new HashMap<Motif, Boolean>();


    public ProxyMotif(Motif m) {
        this.motif = m;
    }

    public boolean isFreq() throws IOException {
        for(Motif t : cache.keySet()) {
            if (cache.get(t) && new HashSet<>(t.getArticles()).containsAll(motif.getArticles())) {
                return cache.get(t);
            } else if (!cache.get(t) && new HashSet<>(motif.getArticles()).containsAll(t.getArticles())) {
                return cache.get(t);
            }
        }
        cache.put(motif, motif.isFreq());
        //ajoutEntreCache(motif, motif.isFreq());
        return cache.get(motif);
    }

    public void ajoutEntreCache(Motif m, boolean b){
        if(b){
            Iterator<Map.Entry<Motif, Boolean>> it = cache.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry item = it.next();
                Transaction t = (Transaction) item.getKey();
                if(new HashSet<>(m.getArticles()).containsAll(t.getArticles())){
                    it.remove();
                }
            }
            cache.put(m, b);
        }else {
            Iterator<Map.Entry<Motif, Boolean>> it = cache.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry item = it.next();
                Transaction t = (Transaction) item.getKey();
                if(new HashSet<>(t.getArticles()).containsAll(m.getArticles())){
                    it.remove();
                }
            }
            cache.put(m, b);
        }
    }

}