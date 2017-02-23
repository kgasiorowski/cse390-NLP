#include "language_modeler.h"

UnigramMap* computeUnigrams(vector<string> wordList){

	UnigramMap* unigramMap = new UnigramMap();

	for(auto const& word:wordList){

		//One match exists
		if(unigramMap->count(word) == 1){
	
			unigramMap->find(word)->second->frequency++;

		}
		else if(unigramMap->count(word) == 0){

			Unigram* newUnigram = new Unigram(word, 1);
			unigramMap->insert({word, newUnigram});

		}
		else
			throw "Error: there was more than one match per unigram.";

	}

	return unigramMap;
	
}

BigramMap* computeBigrams(vector<string> wordList){

	return NULL;

}
