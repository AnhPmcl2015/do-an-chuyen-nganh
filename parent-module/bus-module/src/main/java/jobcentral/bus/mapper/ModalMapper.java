package jobcentral.bus.mapper;

public class ModalMapper {
//	public static PollResponse mapPollToPollResponse(Poll poll, Map<Long, Long> choiceVoteMap, User creator,
//			Long userVote) {
//		
//		PollResponse pollResponse = new PollResponse();
//		pollResponse.setId(poll.getId());
//		pollResponse.setQuestion(poll.getQuestion());
//		pollResponse.setCreationDateTime(poll.getCreatedAt());
//		pollResponse.setExpirationDateTime(poll.getExpirationDateTime());
//		
//		Instant now = Instant.now();
//		pollResponse.setIsExpired(poll.getExpirationDateTime().isBefore(now));
//		
//		List<ChoiceResponse> choiceResponses = poll.getChoices().stream().map(choice->{
//			
//			ChoiceResponse choiceResponse = new ChoiceResponse();
//			choiceResponse.setId(choice.getId());
//			choiceResponse.setText(choice.getText());
//			
//			if(choiceVoteMap.containsKey(choice.getId())) {
//				choiceResponse.setVoteCount(choiceVoteMap.get(choice.getId()));
//			}else {
//				choiceResponse.setVoteCount(0);
//			}
//			
//			return choiceResponse;
//		}).collect(Collectors.toList());
//		
//		pollResponse.setChoices(choiceResponses);
//		UserSummary creatorSummary = new UserSummary(creator.getId(), creator.getUsername());
//		pollResponse.setCreatedBy(creatorSummary);
//		
//		if(userVote != null) {
//			pollResponse.setSelectedChoice(userVote);
//		}
//		
//		long totalVotes = pollResponse.getChoices().stream().mapToLong(ChoiceResponse::getVoteCount).sum();
//		
//		pollResponse.setTotalVotes(totalVotes);
//		return pollResponse;
//		
//	}
}