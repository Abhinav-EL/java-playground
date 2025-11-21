import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BankReconcile {

    public static void main(String[] args) {
        BankReconcile reconcile = new BankReconcile();
    }

    public BankReconcile(){
        List<Transaction> lista = new LinkedList<>();
        lista.add(new Transaction(1, 100));
        lista.add(new Transaction(2, 200));
        lista.add(new Transaction(3, 300));

        List<Transaction> listb = new LinkedList<>();
        listb.add(new Transaction(2, 200));
        listb.add(new Transaction(3, 350));
        listb.add(new Transaction(4, 400));

        reconcile(lista, listb);
    }

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
           System.out.println("Txn B: "+txn);
           if(vala ==null){
                missing_from_a.add(txn);
           } else if (!vala.amount.equals(txn.amount)) {
                //Amount not equal
                amount_mismatches.add(vala);
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

        public String toString(){
            return "Id: "+ this.id + " Amount: "+ this.amount;
        }

        public boolean equals(Transaction txn){
            if(txn==null) return false;
            return this.id.equals(txn.id);
        }

        public int hashcode(){
            return this.id;
        }
    }
}


