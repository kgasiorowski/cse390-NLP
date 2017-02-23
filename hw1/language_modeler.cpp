#include "language_modeler.h"

UnigramMap* computeUnigrams(vector<string> wordList){
	//wordList contains each word that appears in the text
	//document in order.

	UnigramMap* unigramMap = new UnigramMap();

	for(auto const& word:wordList){

		insertUnigram(unigramMap, word);

	}

	return unigramMap;
	
}

BigramMap* computeBigrams(vector<string> wordList){

	BigramMap* bigramMap = new BigramMap();

	register unsigned int i = 0;
	for(;i < wordList.size()-1; i++){

		string word = wordList[i];

		if(bigramMap->count(word) == 1){

			//Bigram match was found. 
			//Read the second word and insert it into this bigram's second word map.
			string secondword = wordList[i+1];
			UnigramMap *secondWordMap = bigramMap->find(word)->second->secondwords;
			insertUnigram(secondWordMap, secondword);

		}
		else if(bigramMap->count(word) == 0){

			//No match found. Create a new bigram and add it.
			Bigram *bigram = new Bigram();
			bigram->firstword = word;
			bigramMap->insert({word, bigram});
			
		}
		else
			throw "Error: there was more than one match per bigram.";	

	}

	return bigramMap;

}

//Increments a unigram's frequency if it is found, 
//otherwise creates a new one and adds it.
void insertUnigram(UnigramMap* map, string word){

	//One match exists
	if(map->count(word) == 1){

		map->find(word)->second->frequency++;

	}
	else if(map->count(word) == 0){

		Unigram* newUnigram = new Unigram(word, 1);
		map->insert({word, newUnigram});

	}
	else
		throw "Error: there was more than one match per unigram.";

}
