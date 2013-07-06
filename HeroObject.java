import org.jsoup.select.Elements;

import java.util.List;

/**
 * Author: Aleksey Alekseenko
 * Date: 06.07.13
 */
public class HeroObject {
    private String detailsUrl;
    private String iconUrl;
    private String name;
    private String picked;
    private String wins;
    private String winPercent;
    private String banned;
    private String pickedPlusBanned;
    private String teamFightParticipation;
    private String teamFightParticipationInVictories;
    private String averageMatchTime;
    private String averageMatchTimeWins;
    private String averageMatchTimeLoss;
    private String averageGPM;
    private String averageWinGPM;
    private String averageLossGPM;

    public HeroObject(Elements el, String detailsUrl, String iconUrl) {
        this.detailsUrl = new StringBuilder().append("http://dota-academy.com").append(detailsUrl).toString();
        this.iconUrl = new StringBuilder().append("http://dota-academy.com").append(iconUrl).toString();
        name = el.get(1).text();
        picked = el.get(2).text();
        wins = el.get(3).text();
        winPercent = el.get(4).text();
        banned = el.get(5).text();
        pickedPlusBanned = el.get(6).text();
        teamFightParticipation = el.get(7).text();
        teamFightParticipationInVictories = el.get(8).text();
        averageMatchTime = el.get(9).text();
        averageMatchTimeWins = el.get(10).text();
        averageMatchTimeLoss = el.get(11).text();
        averageGPM = el.get(12).text();
        averageWinGPM = el.get(13).text();
        averageLossGPM = el.get(14).text();
    }

    public String getNameOfFile() {
        return name;
    }
}
