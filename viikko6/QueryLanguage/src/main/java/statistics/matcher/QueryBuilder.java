package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher returnedQuery = this.matcher;
        this.matcher = new All();
        return returnedQuery;
    }

    public QueryBuilder playsIn(String arg) {
        this.matcher = new And(this.matcher, new PlaysIn(arg));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String arg) {
        this.matcher = new And(this.matcher, new HasAtLeast(value, arg));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String arg) {
        this.matcher = new And(this.matcher, new HasFewerThan(value, arg));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new And(this.matcher, new Or(matchers));
        return this;
    }

}
