package bg.bestsurebet.server.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableScheduling
@Service
public class ScrappingService {

    private final Market1x2Service market1x2Service;
    private final MarketGoalNoGoalService marketGoalNoGoalService;
    private final MarketOverUnder2PointFiveGoalsService marketOverUnder2PointFiveGoalsService;
    private final MarketBothTeamsToScoreService marketBothTeamsToScoreService;

    private final BetanoSheetService betanoSheetService;
    private final EfbetSheetService efbetSheetService;
    private final InbetSheetService inbetSheetService;

    private final WinbetSheetService winbetSheetService;

    private final BetanoService betanoService;
    private final EfbetService efbetService;
    private final InbetService inbetService;
    private final WinbetService winbetService;


    public ScrappingService(Market1x2Service market1x2Service, MarketGoalNoGoalService marketGoalNoGoalService,
                            MarketOverUnder2PointFiveGoalsService marketOverUnder2PointFiveGoalsService, MarketBothTeamsToScoreService marketBothTeamsToScoreService, BetanoSheetService betanoSheetService, EfbetSheetService efbetSheetService, InbetSheetService inbetSheetService, WinbetSheetService winbetSheetService, BetanoService betanoService, EfbetService efbetService, InbetService inbetService, WinbetService winbetService) {
        this.market1x2Service = market1x2Service;
        this.marketGoalNoGoalService = marketGoalNoGoalService;
        this.marketOverUnder2PointFiveGoalsService = marketOverUnder2PointFiveGoalsService;
        this.marketBothTeamsToScoreService = marketBothTeamsToScoreService;
        this.betanoSheetService = betanoSheetService;
        this.efbetSheetService = efbetSheetService;
        this.inbetSheetService = inbetSheetService;
        this.winbetSheetService = winbetSheetService;
        this.betanoService = betanoService;
        this.efbetService = efbetService;
        this.inbetService = inbetService;
        this.winbetService = winbetService;
    }

//    @Scheduled(fixedDelay = 60 * 60 * 1000, initialDelay = 1 * 20 * 1000)
    public void startScrapping() {
//        this.market1x2Service.deleteAllMarkets1x2();
//        this.marketGoalNoGoalService.deleteAllMarketsGoalNoGoal();
//        this.marketOverUnder2PointFiveGoalsService.deleteAllMarketsOverUnder2PointFiveGoals();
//        this.marketBothTeamsToScoreService.deleteAllMarketsBothTeamsToScore();
//
//        this.betanoSheetService.deleteAllBetanoSheet();
//        this.efbetSheetService.deleteAllEfbetSheet();
//        this.inbetSheetService.deleteAllInbetSheet();
//        this.winbetSheetService.deleteAllWinbetSheet();
//
//        this.betanoService.scrappingBetano();
//        this.efbetService.scrappingEfbet();
//        this.inbetService.scrappingInbet();
//        this.winbetService.scrappingWinbet();

    }
}
