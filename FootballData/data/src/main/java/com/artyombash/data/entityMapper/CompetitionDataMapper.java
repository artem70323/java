package com.artyombash.data.entityMapper;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.LinksData;
import com.artyombash.domain.entity.Competition;
import com.artyombash.domain.entity.Links;
import com.artyombash.domain.entity.links.LinkToFixtures;
import com.artyombash.domain.entity.links.LinkToLeagueTable;
import com.artyombash.domain.entity.links.LinkToSelf;
import com.artyombash.domain.entity.links.LinkToTeams;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link CompetitionData} (in the data layer) to {@link Competition}
 * in the domain layer.
 */
@Singleton
public class CompetitionDataMapper {

    @Inject
    public CompetitionDataMapper() {}

    /**
     * Transform a {@link CompetitionData} into a {@link Competition}.
     *
     * @param competitionData Object to be transformed.
     * @return {@link Competition} if valid {@link CompetitionData} otherwise null.
     */
    public List<Competition> transform(List<CompetitionData> competitionData) {
        List<Competition> competitions = null;
        if (competitionData != null) {
            competitions = new ArrayList<>();
            Competition competition;
            for (CompetitionData data : competitionData) {
                competition = new Competition();
                competition.setId(data.getId());
//                competition.setLinks(transformLinks(data.getLinks()));
                competition.setCaption(data.getCaption());
                competition.setLeague(data.getLeague());
                competition.setYear(data.getYear());
                competition.setCurrentMatchday(data.getCurrentMatchday());
                competition.setNumberOfMatchdays(data.getNumberOfMatchdays());
                competition.setNumberOfTeams(data.getNumberOfTeams());
                competition.setNumberOfGames(data.getNumberOfGames());
                competition.setLastUpdated(data.getLastUpdated());
                competitions.add(competition);
            }
        }
        return competitions;
    }


//    private Links transformLinks(LinksData linksData) {
//        Links links = null;
//        if (linksData != null) {
//            LinkToSelf linkToSelf = new LinkToSelf();
//            LinkToTeams linkToTeams = new LinkToTeams();
//            LinkToFixtures linkToFixtures = new LinkToFixtures();
//            LinkToLeagueTable linkToLeagueTable = new LinkToLeagueTable();
//
//            linkToSelf.setHref(linksData.getSelf().getHref());
//            linkToTeams.setHref(linksData.getTeams().getHref());
//            linkToFixtures.setHref(linksData.getFixtures().getHref());
//            linkToLeagueTable.setHref(linksData.getLeagueTable().getHref());
//
//            links.setSelf(linkToSelf);
//            links.setTeams(linkToTeams);
//            links.setFixtures(linkToFixtures);
//            links.setLeagueTable(linkToLeagueTable);
//        }
//        return links;
//    }

}
