#include "io.h"

/*

	Part 1

	Kuba Gasiorowski
	kgasiorowski
	109776237
	kuba.gasiorowski@stonybrook.edu
	
	Takes an input file and tokenizes it first to sentences (delimited simply by '.')
	And later to words (delimited simply by ' ').
	
	Escape characters and punctuation are ignored.
	
	String trimming code taken from: 
	http://stackoverflow.com/questions/216823/whats-the-best-way-to-trim-stdstring
	

*/

// trim from start
string& ltrim(string& s) {
    s.erase(s.begin(), find_if(s.begin(), s.end(),
            not1(ptr_fun<int, int>(isspace))));
    return s;
}

// trim from end
string& rtrim(string& s) {
    s.erase(find_if(s.rbegin(), s.rend(),
            not1(ptr_fun<int, int>(isspace))).base(), s.end());
    return s;
}

// trim from both ends
string& trim(string& s) {
    return ltrim(rtrim(s));
}

vector<string>* wordTokenizer(string sentence){

	vector<string>* words = new vector<string>();
	
	char *token = strtok((char*)sentence.c_str(), " ");
	
	while(token != NULL){
	
		words->push_back(string(token));
		
		token = strtok(NULL, " ");
	
	}
	
	return words; 

}

vector<string>* sentenceTokenizer(ifstream& file){

	vector<string>* rtn = new vector<string>();
	char* const SENTENCE_BUFFER = (char*)calloc(MAX_SENTENCE, sizeof(char));
	
	char *bufferPtr = SENTENCE_BUFFER;

	if(SENTENCE_BUFFER == NULL)
		throw "There was a problem with allocating memory!";

	unsigned char c = 0;

	while(!file.eof()){

		while(!file.eof() && (c = file.get()) != '.'){
		
				//Swap any newline or other whitespace for a regular whitespace
				if(c == '\t' || c == '\v' || c == '\t' || c == '\n' || ispunct(c))
					c = ' ';
					
				*bufferPtr++ = c; // Copy the sentence until you hit a period
		
		}

		*bufferPtr = 0; // Null terminate

		string sentence(SENTENCE_BUFFER);
		sentence = trim(sentence);
		
		if(sentence[0] == -1)
			break;
		
		rtn->push_back(sentence); // Add the sentence
		bufferPtr = SENTENCE_BUFFER; // Reset the buffer pointer

	}

	free(SENTENCE_BUFFER);
	return rtn;

}