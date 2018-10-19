#12
#SELECT COUNT(title) FROM Title 
#	JOIN TitleType ON Title.type = TitleType.id
#	WHERE text = 'videoGame';


#SELECT title, avgRating FROM 
#	Rating JOIN
#		Title ON Title.id = Rating.titleId
#	WHERE numVotes = (SELECT MAX(numVotes) FROM Rating)-- 2002417
#	LIMIT 100;


#SELECT name FROM 
#	ActedIn JOIN
#		Title ON ActedIn.titleId = Title.id JOIN
#		Person ON ActedIn.personId = Person.id
#	WHERE title = "But I'm a Cheerleader"

#16
#SELECT COUNT(*) FROM
#	Person
#		JOIN HasProfession ON Person.id = HasProfession.personId
#		JOIN Profession ON HasProfession.professionId = Profession.id
#	WHERE text = 'stunts';


#17
#SELECT seasonNum, episodeNum, Title2.title FROM Title
#	JOIN EpisodeOf ON Title.id = EpisodeOf.seriesId
#	JOIN Title AS Title2 ON Title2.id = EpisodeOf.episodeId
#	WHERE Title.title LIKE 'Babylon 5%'
#	ORDER BY seasonNum, episodeNum;

#18
#SELECT text, COUNT(type) FROM 
#	Title JOIN 
#		TitleType ON Title.type = TitleType.id
#	GROUP BY type
#	LIMIT 100;

#19 + 20
SELECT text, AVG(runtime) FROM
	Genre JOIN
		OfGenre ON Genre.id = OfGenre.genreId JOIN
		Title ON OfGenre.titleId = Title.id
	WHERE runtime != 0
	GROUP BY genreId
#	HAVING AVG(runtime) < 45
	ORDER BY AVG(runtime)
	LIMIT 100;

#21
#SELECT COUNT(personId), personId, name FROM Title
#	JOIN EpisodeOf ON Title.id = EpisodeOf.seriesId
#	JOIN Title AS Title2 ON Title2.id = EpisodeOf.episodeId
#	JOIN Wrote ON Wrote.titleId = Title2.id
#	JOIN Person ON Person.id = Wrote.personId
#	WHERE Title.title LIKE 'Babylon 5%'
#	GROUP BY personId
#	HAVING COUNT(personId) >= 5;
