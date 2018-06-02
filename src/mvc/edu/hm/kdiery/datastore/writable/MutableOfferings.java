package MVC.edu.hm.kdiery.datastore.writable;


public abstract class MutableOfferings {

    public AllOffers make(MutableArtwork... artworks) {
        return new AllOffers(artworks);
    }

}
