#include <cstdio>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

#define MAX_SENTENCE 1000

using namespace std;

vector<string>* sentenceTokenizer(ifstream& file){

	vector<string>* rtn = new vector<string>();
	char* const SENTENCE_BUFFER = (char*)calloc(MAX_SENTENCE, sizeof(char));
	
	char *bufferPtr = SENTENCE_BUFFER;

	if(SENTENCE_BUFFER == NULL)
		throw "There was a problem with allocating memory!";

	char c = 0;

	while(!file.eof()){

		while(!file.eof() && (c = file.get()) != '.')
				*bufferPtr++ = c; //Copy the sentence until you hit a period

		*bufferPtr = 0; //Null terminate
		rtn->push_back(string(SENTENCE_BUFFER)); // Add the sentence
		bufferPtr = SENTENCE_BUFFER;

		cerr << "Sentence scanned: " << rtn->back() << endl << endl;

	}

	return rtn;

}

int main(){

	string filename;
	cout << "Enter filename: ";
	cin >> filename;

	ifstream file;
	file.open(filename.c_str(), ios::in);

	vector<string>* sentences = sentenceTokenizer(file);

	file.close();

	for(auto const& s: *sentences){

		cout << "Sentence: <" << s << ">" << endl;

	} 

	return 0;	

}
