USE adlister_db;

INSERT INTO users (username, email, password)
VALUES ('Bobby Bob', 'bobby@email.com', '$2a$12$hMBHftmWPtdIWrgX1My8Wuhz9wrZULG5MrqmoVwCSBH24t/DDlPNS'),
       ('Sally Smith', 'sally@email.com', '$2a$12$hMBHftmWPtdIWrgX1My8Wuhz9wrZULG5MrqmoVwCSBH24t/DDlPNS'),
       ('Karen Schultz', 'karen@email.com', '$2a$12$hMBHftmWPtdIWrgX1My8Wuhz9wrZULG5MrqmoVwCSBH24t/DDlPNS'),
       ('Fred White', 'fred@email.com', '$2a$12$hMBHftmWPtdIWrgX1My8Wuhz9wrZULG5MrqmoVwCSBH24t/DDlPNS'),
       ('Bud Gibson', 'bud@email.com', '$2a$12$hMBHftmWPtdIWrgX1My8Wuhz9wrZULG5MrqmoVwCSBH24t/DDlPNS');
INSERT INTO ads (user_id, title, description, price, category)
VALUES
(1, 'Dabbing', 'Dabbing, or the dab, is a simple dance move in which a person drops the head into the bent crook of a slanted arm, often while raising the opposite arm in a parallel direction but out straight. Since 2015, it has also been used as a gesture of triumph or playfulness, becoming a youthful American dance fad and Internet meme.[1] The move looks similar to someone sneezing into the "inside" of their elbow.. - (https://en.wikipedia.org/wiki/Dab_(dance))', 20, 'fad'),
(2, 'Super Soakers', 'Super Soaker is a brand of recreational water gun that utilizes manually-pressurized air to shoot water with greater power, range, and accuracy than conventional squirt pistols. The Super Soaker was invented in 1982 by engineer Lonnie Johnson. The prototype combined PVC pipe, acrylic glass, and an empty plastic soda bottle. - (https://en.wikipedia.org/wiki/Super_Soaker)', 15, 'fad'),
(2, 'Pogs', 'Pogs, generically called milk caps, is a game that was popular among children during the mid 1990s. - (https://en.wikipedia.org/wiki/Milk_caps_(game))', 20, 'fad'),
(4, 'Spinners', 'A fidget spinner is a toy that consists of a ball bearing in the center of a multi-lobed (typically two or three) flat structure made from metal or plastic designed to spin along its axis with little effort. Fidget spinners became popular toys in April 2017, although similar devices had been invented as early as 1993. - (https://en.wikipedia.org/wiki/Fidget_spinner)', 15, 'fad'),
(1, 'The Word "Tubular"', 'Surfing (particularly in Southern California) has its own sociolect, which has comingled with Valleyspeak. Words such as "dude", "tubular", "radical", and "gnarly" are associated with both and Northern California created its own unique surf terms as well that include "groovy", "hella", and "tight". - (https://en.wikipedia.org/wiki/Surf_culture#Surf_terminology)', 15, 'fad'),
(4, 'Surge', 'Surge (sometimes styled as SURGE) is a citrus flavored soft drink first produced in the 1990s by The Coca-Cola Company to compete with Pepsi''s Mountain Dew. - (https://en.wikipedia.org/wiki/Surge_(drink))', 20, 'fad'),
(1, 'The Nintendo 64', 'The Nintendo 64 (Japanese: ニンテンドウ64 Hepburn: Nintendō Rokujūyon), stylized as NINTENDO64 and abbreviated to N64, is Nintendo''s third home video game console for the international market. Named for its 64-bit central processing unit, it was released in June 1996 in Japan, September 1996 in North America and Brazil, March 1997 in Europe and Australia, September 1997 in France. - (https://en.wikipedia.org/wiki/Nintendo_64)', 15, 'fad'),
(4, 'Pagers', 'A pager (also known as a beeper) is a wireless telecommunications device that receives and displays alphanumeric messages and/or receives and announces voice messages. One-way pagers can only receive messages, while response pagers and two-way pagers can also acknowledge, reply to, and originate messages using an internal transmitter. - (https://en.wikipedia.org/wiki/Pager)', 15, 'fad');
INSERT INTO categories (id, categories)
VALUES
(1, 'vehicles'),
(2, 'toys'),
(3, 'electronics'),
(4, 'household goods'),
(5, 'furniture'),
(6, 'fad'),
(7, 'outdoor living');