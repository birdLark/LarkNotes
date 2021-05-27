package Thread.channel;

import java.util.Collection;

public abstract class Channel {

	public void push(final String r) {
		this.doPush(r);
	}

	public void pushAll(final Collection<String> rs) {
		this.doPushAll(rs);
	}

	public String pull() {
		return this.doPull();
	}

	public void pullAll(final Collection<String> rs) {
		this.doPullAll(rs);
	}

	protected abstract void doPush(String r);

	protected abstract void doPushAll(Collection<String> rs);

	protected abstract String doPull();

	protected abstract void doPullAll(Collection<String> rs);
}
