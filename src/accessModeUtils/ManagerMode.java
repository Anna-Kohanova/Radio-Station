package accessModeUtils;

public interface ManagerMode <T> {
    void listenToMusic();
    void dayProgramView();
    void collectionOrderChange();
    
    void collectionFormation();
    void addNewTrack(T track);
    void deleteTrack(T track);
    void editTrack(T track);
}
