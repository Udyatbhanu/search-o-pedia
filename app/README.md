# Search O Pedia

The app is used to search for your team mates filtering out blacklisted texts, the search term which does not return a result is written into shared preferences which blacklists the term for future searches. 

Initially the blacklist.txt file is read into memory using a Trie data structure for subsequent searches the Trie data structure is used. The app is broken into dagger modules which are meant to do specific tasks for e.g Network module is only concerned with providing Retrofit object used to make the search api call. File Access provider is used for reading file in the raw folder.

# Improvements and TODOs

For future there can be a more memory optimized trie data structure implementation, and add test cases for the modules and the core libraries. There could be more build flavors like dev, QA, release, optimized for each environments. There could be more efficient implentation of dagger and also utilize the power of Rx fully.

