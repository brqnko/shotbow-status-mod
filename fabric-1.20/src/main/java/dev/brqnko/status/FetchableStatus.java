package dev.brqnko.status;

public abstract class FetchableStatus {

    private boolean fetching;

    public boolean isFetching() {
        return this.fetching;
    }

    public void setFetching(boolean fetching) {
        this.fetching = fetching;
    }
}
