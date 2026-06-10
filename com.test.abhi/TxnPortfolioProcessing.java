import java.util.*;

public class TxnPortfolioProcessing {

    static class Transaction {
        String action;
        String ticker;
        int quantity;

        public Transaction(String action, String ticker, int quantity) {
            this.action = action;
            this.ticker = ticker;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "(" + action + ", " + ticker + ", " + quantity + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Transaction other = (Transaction) obj;
            return quantity == other.quantity
                    && Objects.equals(action, other.action)
                    && Objects.equals(ticker, other.ticker);
        }

        @Override
        public int hashCode() {
            return Objects.hash(action, ticker, quantity);
        }
    }

    static class Result {
        Map<String, Integer> portfolio;
        List<Transaction> invalidTransactions;

        public Result(Map<String, Integer> portfolio,
                      List<Transaction> invalidTransactions) {
            this.portfolio = portfolio;
            this.invalidTransactions = invalidTransactions;
        }
    }

    public static Result processTransactions(
            Map<String, Integer> portfolio,
            List<Transaction> transactions) {

        Map<String, Integer> positions = new HashMap<>(portfolio);
        List<Transaction> invalidTransactions = new ArrayList<>();
        
        for(Transaction transaction : transactions){
            switch(transaction.action){
                case "BUY":
                    Integer currPos = positions.getOrDefault(transaction.ticker, 0);
                    positions.put(transaction.ticker, currPos + transaction.quantity);
                    break;
                case "SELL":
                    if(!positions.containsKey(transaction.ticker)){
                        invalidTransactions.add(transaction);
                        break;
                    }
                    Integer currPosSell = positions.get(transaction.ticker);
                    if(transaction.quantity>currPosSell){
                        invalidTransactions.add(transaction);
                    } else {
                        if(currPosSell - transaction.quantity == 0){
                            positions.remove(transaction.ticker);
                            break;
                        }
                        positions.put(transaction.ticker, currPosSell - transaction.quantity);
                    }
                    break;
                default:
                    invalidTransactions.add(transaction);
                    break;
            }
        }

        return new Result(positions, invalidTransactions);
    }

    public static void main(String[] args) {

        Map<String, Integer> portfolio = new HashMap<>();
        portfolio.put("AAPL", 100);
        portfolio.put("MSFT", 50);
        portfolio.put("GOOG", 25);

        List<Transaction> transactions = List.of(
                new Transaction("BUY", "AAPL", 20),
                new Transaction("SELL", "MSFT", 10),
                new Transaction("BUY", "NVDA", 15),
                new Transaction("SELL", "GOOG", 25),
                new Transaction("SELL", "AAPL", 500), //Excess Sell
                new Transaction("SELL", "RIVN", 500), //Random Ticker
                new Transaction("BUY", "AAPL", 25), //Multiple operations on APPL
                new Transaction("SELL", "AAPL", 10),
                new Transaction("RANDOM", "AAPL", 35), //Random operation
                new Transaction("BUY", "GOOG", 25) // Buy GOOG again after going down to 0
        );

        Result result = processTransactions(portfolio, transactions);

        Map<String, Integer> portfolioResult = new HashMap<>();
        portfolioResult.put("AAPL", 135);
        portfolioResult.put("MSFT", 40);
        portfolioResult.put("GOOG", 25);
        portfolioResult.put("NVDA", 15);

        System.out.println("Final Portfolio Result Matches:");
        System.out.println(portfolioResult.equals(result.portfolio));

        List<Transaction> resultTransactions = List.of(
            new Transaction("SELL", "AAPL", 500),
            new Transaction("SELL", "RIVN", 500),
            new Transaction("RANDOM", "AAPL", 35)
        );
         System.out.println("\nInvalid Transactions Match:");
         System.out.println(resultTransactions.equals(resultTransactions));
         System.out.println(resultTransactions.size() == result.invalidTransactions.size());
    }
}