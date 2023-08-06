package dao;

import java.sql.Time;

public class Route {
	
	private int rid;
    private String src;
    private String dest;
    private Time journeyTime;
    private float distance;
	
    @Override
	public String toString() {
		return "Route [rid=" + rid + ", src=" + src + ", dest=" + dest + ", journeyTime=" + journeyTime + ", distance="
				+ distance + "]";
	}



    public Route(int rid, String src, String dest, Time journeyTime, float distance) {
        this.rid = rid;
        this.src = src;
        this.dest = dest;
        this.journeyTime = journeyTime;
        this.distance = distance;
    }

    public Route() {
		// TODO Auto-generated constructor stub
	}

	public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Time getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(Time journeyTime) {
        this.journeyTime = journeyTime;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}