create table GamesDetails(
    GameTitle varchar(255) not null primary key,
    GameGenre varchar(255),
    GameDeveloper varchar(255),
    GameRelease integer,
    GamePriceInEuro integer,
    GameoftheYear boolean,
    GameConsoleRelease varchar(255),
    GameRating Integer
);

Drop Table GamesDetails;

Select * from GamesDetails;

INSERT INTO GamesDetails(GameTitle, GameGenre, GameDeveloper, GameRelease, GamePriceInEuro, GameoftheYear, GameConsoleRelease, GameRating)
VALUES('Apex Legends','First Person Shooter,Battle Roysle','Respawn Entertainment,Panic Button Games',2019,0,False,'PC,Xbox One,PS4',9),
('Assassins Creed Brotherhood','Historic,Action-Adventure','Ubisoft Montreal,Ubisoft Ukraine',2010,15,False,'PC,Xbox One,PS4',8),
('Batman Arkham Asylum','Action-Adventure','Rocksteady Studios',2009,20,True,'PC,Xbox One,PS4',9),
('Battlefield 1','First-Person Shooter','EA DICE',2016,40,False,'PC,Xbox One,PS4',7),
('Bioshock','First-Person Shooter','2K Boston,2K Australia',2007,30,True,'PC,Xbox One,PS4',5),
('Bloodborne','Action ,Role-Playing','FromSoftware',2015,45,True,'PS4',6),
('Borderlands 3','Action,Role-Playing,First-Person Shooter','Gearbox Software',2019,59,False,'PC,Xbox One,PS4',7),
('Call Of Duty Modern Warfare 2','First-Person Shooter','Infinity Ward,Bennox(Remastered)',2009,45,True,'PC,Xbox One,PS4',8),
('Deus Ex Mankind Divided','Action,Role-Playing,First-Person Shooter,Stealth','Eidos Montréal',2016,30,False,'PC,Xbox One,PS4',7),
('Fallout 4','Action,Role-Playing','Bethesda Game Studios',2015,49,True,'PC,Xbox One,PS4',6),
('God of War(2018)','Action-Adventure,Hack And Slash','Santa Monica Studios',2018,59,True,'PS4',10),
('Grand Theft Auto 5','Action-Adventure','Rockstar North',2013,15,True,'PC,Xbox One,PS4',10),
('Lords Of The Fallen','Action,Role-Playing','Deck 13 Interactive,CI Games',2014,12,False,'PC,Xbox One,PS4',7),
('Metro: Last Light','First-Person Shooter,Survival Horror','4A Games',2013,27,False,'PC,Xbox One,PS4',7),
('Minecraft','SandBox,Survival','Mojang',2011,20,True,'PC',8),
('Portal','Puzzle-Platform','Valve',2007,10,True,'PC',6),
('Runescape','Fantasy,MMORPG','Jagex',2001,0,False,'PC',8),
('Skyrim','Action ,Role-Playing','Bethesda Game Studio',2011,30,True,'PC,Xbox One,PS4',9),
('Uncharted 3: Drakes Deception','Action-Adventure,Third-Person Shooter,Platformer','Naughty Dog',2011,15,True,'PS4',10),
('We Were Here','First-Person,Puzzle','Total Mayhem Games',2017,12,False,'PC,Xbox One,PS4',8);

Select Count(*) From Gamesdetails;
Select AVG(GamePriceInEuro) From GamesDetails;
SELECT Count(*) FROM Gamesdetails Where GameGenre Like '%Action-%' or GameGenre like 'Action%';
Select Count(*) FROM Gamesdetails Where GameRelease <2018; 
Select Count(*) From Gamesdetails where GameRating >8;
Select Count(*) From Gamesdetails where GameoftheYear = True;
Select Count(*) From Gamesdetails where GamePriceInEuro >40;
Select Count(*) From GamesDetails where GameConsoleRelease like '%PC';