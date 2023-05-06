# GenerateMaxPlaylist
## Description
This program generates maximum playlists (all or a limited number, if there are too many) that contain only unrelated albums. Two albums are related if they meet at least one of the following conditions: they are composed by the same artist, they were released in the same year, or they have at least one common genre.

# Method
- __public GenerateMaxPlaylist(Connection connection, int maxAlbums) throws SQLException__ : The constructor takes in a Connection object and the maximum number of albums to include in the playlists.
- __public List<List<Album>> generatePlaylist() throws SQLException__ : This method generates a list of playlists, where each playlist contains unrelated albums. It returns a list of List<Album> objects, where each List<Album> object represents a playlist. Each Album object contains information about an album, such as its ID, release year, title, and artist ID.
- __private List<Album> getUnrelatedAlbums(int album_id) throws SQLException__ : This method takes in an album ID and returns a list of unrelated albums. It queries the database for all albums that are not related to the album with the given ID, and it returns a list of Album objects that represent those albums.
- __private boolean areRelated(Album album1, Album album2) throws SQLException__ : This method takes in two Album objects and checks if they are related. Two albums are related if they meet at least one of the following conditions: they are composed by the same artist, they were released in the same year, or they have at least one common genre. If the two albums are related, the method returns true. Otherwise, it returns false.
