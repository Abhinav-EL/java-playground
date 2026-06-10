import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TxnReconcile {

    public static void main(String[] args) {
        List<Transaction> lista = new LinkedList<>();
        lista.add(new Transaction(1, 100));
        lista.add(new Transaction(2, 200));
        lista.add(new Transaction(3, 300));

        List<Transaction> listb = new LinkedList<>();
        listb.add(new Transaction(2, 200));
        listb.add(new Transaction(3, 350));
        listb.add(new Transaction(4, 400));

        TxnReconcile txnReconcile = new TxnReconcile();
        txnReconcile.reconcile(lista, listb);
        txnReconcile.reconcile2(lista, listb);
    }

    //less efficient and slightly dangerous with removing from lists.
    public void reconcile(List<Transaction> lista, List<Transaction> listb){
        List<Transaction> missing_from_a = new LinkedList<>();
        List<Transaction> missing_from_b = new LinkedList<>();
        List<Transaction> amount_mismatches = new LinkedList<>();

        Map<Integer, Transaction> mapa = new HashMap<>();
        Map<Integer, Transaction> mapb = new HashMap<>();

        for(Transaction txn : lista){
            mapa.put(txn.id, txn);
        }

        for(Transaction txn : listb){
            mapb.put(txn.id, txn);
        }

        for(Transaction txn : lista){
           Transaction valb =  mapb.get(txn.id);
           
           if(valb ==null){
                missing_from_b.add(txn);
           } else if (!valb.amount.equals(txn.amount)) {
                //Amount not equal
                amount_mismatches.add(valb);
                System.out.println("Txn A Matches: "+ listb.remove(valb));
           }
        }

        for(Transaction txn : listb){
           Transaction vala =  mapa.get(txn.id);
           //System.out.println("Txn B: "+txn);
           if(vala ==null){
                missing_from_a.add(txn);
           } else if (!vala.amount.equals(txn.amount)) {
                //Amount not equal
                amount_mismatches.add(vala);
           } 
        }

        for(Transaction txn: missing_from_a){
            System.out.println("Missing from A: "+ txn);
        }
        for(Transaction txn: missing_from_b){
            System.out.println("Missing from B: "+ txn);
        }
        for(Transaction txn: amount_mismatches){
            System.out.println("Mis Match: "+ txn);
        }
    }

    private void reconcile2(List<Transaction> lista, List<Transaction> listb){
        Map<Integer, Transaction> mapA = new HashMap<>();
        Map<Integer, Transaction> mapB = new HashMap<>();
        
        List<Transaction> missingFromA = new LinkedList<>();
        List<Transaction> misingFromB = new LinkedList<>();
        List<Transaction> amountMismatch = new LinkedList<>();

        for(Transaction txn: lista){
            mapA.put(txn.id, txn);
        }

        for(Transaction txn: listb){
            Transaction existInA = mapA.get(txn.id);
            if(existInA==null){
                missingFromA.add(txn);
            } else {
                if(!txn.amount.equals(existInA.amount)){
                    amountMismatch.add(txn);
                    amountMismatch.add(existInA);
                }
            }
            mapB.put(txn.id, txn);
        }

        for(Transaction txn: lista){
            Transaction returnedTxn = mapB.get(txn.id);
            if(returnedTxn==null){
                misingFromB.add(txn);
            }
        }

        System.out.println("------------Method 2------");
        for(Transaction txnA: missingFromA){
            System.out.println("Missing_from_A: "+ txnA);
        }
        for(Transaction txnB: misingFromB){
            System.out.println("Missing_from_B: "+ txnB);
        }
        for(Transaction txn: amountMismatch){
            System.out.println("Mis_Match: "+ txn);
        }
        
    }
}

class Transaction{
    Integer id;
    Integer amount;

    Transaction(Integer id, Integer amount){
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "Id: "+ this.id + " Amount: "+ this.amount;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return false;
        if(obj==null || getClass() != obj.getClass())
            return false;

        Transaction txn = (Transaction) obj;
        return this.id.equals(txn.id);
    }

    @Override
    public int hashCode(){
        return this.id;
    }
}
