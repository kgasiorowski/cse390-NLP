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
		string secondword = wordList[i+1];

		cerr << "On words: " << word << " | " << secondword << endl;

		if(bigramMap->count(word) == 1){

			//Bigram match was found. 
			//Read the second word and insert it into this bigram's second word map.
			Bigram *bigram = bigramMap->find(word)->second;
			bigram->frequency++;
			
			insertUnigram(bigram->secondwords, secondword);

			cerr << "Match found. New bigram freq: " << setw(2) << bigram->frequency << " | Inserted" << endl; 

		}
		else if(bigramMap->count(word) == 0){

			//No match found. Create a new bigram and add it.
			Bigram *bigram = new Bigram();
			bigram->firstword = word;
			bigramMap->insert({word, bigram});
			
			insertUnigram(bigram->secondwords, secondword);			

			cerr << "No match found. New bigram added: " << setw(5) << bigram->firstword << " | Frequency: " << bigram->frequency << endl;

		}
		else
			throw "Error: there was more than one match per bigram.";	

		cerr << endl;

	}

	string word = wordList[wordList.size()-1];
	if(bigramMap->count(word) == 1){

		bigramMap->find(word)->second->frequency++;

	}
	else if(bigramMap->count(word) == 0){

		cerr << "BOOBS!!!" << endl;

		Bigram *bigram = new Bigram();
		bigram->firstword = word;
		bigramMap->insert({word, bigram});

	}
	else 
		throw "ERROR!";

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
