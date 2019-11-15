public class LoadingPlatform {
    private boolean platformUp = false;
    private int loadingAngle;
    //konstruktor? skapa ett flak med konstruktor
    //downbelowangle
    public LoadingPlatform(int loadingAngle){
        this.loadingAngle = loadingAngle;
    }

    private void platformMove(int angle, int max, int min){
        loadingAngle += angle;
        if(loadingAngle > max){
            loadingAngle = max;
        }else if(loadingAngle < min){
            loadingAngle = min;
        }
        if(loadingAngle > min){
            platformUp = true;
        }
    }

    public int getLoadingAngle() {
        return loadingAngle;
    }
    public void setLoadingAngle(int loadingAngle) {
        this.loadingAngle = loadingAngle;
    }
    public boolean isPlatformUp() {
        return platformUp;
    }
    public void setPlatformUp(boolean platformUp) {
        this.platformUp = platformUp;
    }
}