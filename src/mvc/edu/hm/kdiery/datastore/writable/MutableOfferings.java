package mvc.edu.hm.kdiery.datastore.writable;

import java.util.stream.Stream;

import mvc.edu.hm.kdiery.datastore.readonly.Offerings;

public abstract class MutableOfferings extends Offerings {

	MutableOfferings make(MutableArtwork... artworks) {
		return new AllOffers(Stream.of(artworks));
	}

}
