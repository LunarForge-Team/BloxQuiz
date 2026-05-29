package com.example.model

import androidx.compose.ui.graphics.Color

object PlacesData {
    val places = listOf(
        RobloxPlace(
            id = "adopt_me",
            enName = "Adopt Me!",
            ruName = "Adopt Me! (Усынови меня!)",
            enHint = "A mega-popular game about collecting, trading, and raising legendary pets, hatching eggs, and styling your own cute houses.",
            ruHint = "Мега-популярная игра о коллекционировании, обмене и выращивании легендарных питомцев, вылуплении яиц и обустройстве уютных домов.",
            emoji = "🐶🥚🏠",
            themeColor = Color(0xFF00ACC1),
            category = "Roleplay / Sim",
            difficulty = "Easy",
            scenes = listOf(
                PlaceScene(
                    emoji = "🐶🍳🏠",
                    enHint = "Raising and caring for adorable baby pets inside extremely detailed, fully customized cozy homes.",
                    ruHint = "Выращивание и забота о милых питомцах и малышах в детализированных уютных домах со своим стилем.",
                    themeColor = Color(0xFF00ACC1)
                ),
                PlaceScene(
                    emoji = "🥚✨🦄",
                    enHint = "Trading legendary neon pets at the city center. Did you hatch an ultra-rare glittering unicorn from that royal egg?",
                    ruHint = "Торговля неоновыми питомцами в центре города. Вылупился ли редкий сверкающий единорог из королевского яйца?",
                    themeColor = Color(0xFF26C6DA)
                ),
                PlaceScene(
                    emoji = "🐱🚗🎈",
                    enHint = "Exploring Adoption Island, buying colorful balloons, and driving a luxury limousine packed with friends and pets!",
                    ruHint = "Исследование Острова Адопшен, покупка разноцветных шаров и поездка на лимузине с друзьями и питомцами!",
                    themeColor = Color(0xFF80DEEA)
                )
            )
        ),
        RobloxPlace(
            id = "brookhaven",
            enName = "Brookhaven RP",
            ruName = "Brookhaven RP (Брукхейвен)",
            enHint = "A city roleplaying game where you can own amazing modern mansions, drive cool supercars, and act out stories with friends in a rich town.",
            ruHint = "Симулятор жизни в городе, где вы можете владеть роскошными особняками, водить быстрые суперкары и разыгрывать истории с друзьями.",
            emoji = "🏙️🚗🏡",
            themeColor = Color(0xFF43A047),
            category = "Roleplay",
            difficulty = "Easy",
            scenes = listOf(
                PlaceScene(
                    emoji = "🏙️🚗🏡",
                    enHint = "Owning luxurious modern mansions with hidden vaults, driving fast sports cars, and choosing custom town roles.",
                    ruHint = "Владение роскошными особняками со скрытыми сейфами, вождение спорткаров и примерка сотен городских ролей.",
                    themeColor = Color(0xFF43A047)
                ),
                PlaceScene(
                    emoji = "🍕🛒🏫",
                    enHint = "Hanging out in Brookhaven high school, working at the pizzeria, or doing a stealthy bank heist with a green tool!",
                    ruHint = "Прогулки по школе Брукхейвена, работа в местной пиццерии или тихое ограбление банка с помощью зеленого взрыв-пакета!",
                    themeColor = Color(0xFF66BB6A)
                ),
                PlaceScene(
                    emoji = "🚒🏥🚓",
                    enHint = "Roleplaying as a heroic fireman, a doctor in the city hospital, or a police officer patrolling the beautiful cozy town.",
                    ruHint = "Ролевая игра за спасателя-пожарного, врача в центральной больнице или офицера полиции на патруле тихого городка.",
                    themeColor = Color(0xFF81C784)
                )
            )
        ),
        RobloxPlace(
            id = "tower_of_hell",
            enName = "Tower of Hell",
            ruName = "Tower of Hell (Башня Ада)",
            enHint = "A competitive parkour obby where you scale a multi-colored vertically generated cylinder. One mistake resets your entire climb!",
            ruHint = "Сложный вертикальный паркур-обби, где нужно вскарабкаться по разноцветной случайно сгенерированной башне. Ошибка сбрасывает весь прогресс!",
            emoji = "🗼⚡🔥",
            themeColor = Color(0xFFD81B60),
            category = "Obby / Parkour",
            difficulty = "Hard",
            scenes = listOf(
                PlaceScene(
                    emoji = "🗼⚡🔥",
                    enHint = "Sprinting up a glowing cylinder of neon laser beams, rotating platforms, and speed modifiers before the clock runs out!",
                    ruHint = "Бег по вертикальному неоновому цилиндру с лазерными лучами, крутящимися платформами и бустами скорости на время!",
                    themeColor = Color(0xFFD81B60)
                ),
                PlaceScene(
                    emoji = "🌈💀⏰",
                    enHint = "A competitive parkour tower where purchasing global shields, extra time, or jump boots helps you conquer the top first.",
                    ruHint = "Паркур-состязание, где покупка общего щита, дополнительного времени или прыгучих ботинок помогает занять топ раньше всех.",
                    themeColor = Color(0xFFEC407A)
                ),
                PlaceScene(
                    emoji = "🧱🥶🔥",
                    enHint = "Avoiding deathly laser walls, slippery ice ledges, and deadly conveyor lines. One slip-up resets you back to level zero!",
                    ruHint = "Избегание смертоносных лазерных стен, скользких ледяных уступов и быстрых конвейеров. Одно неверное движение — и ты в самом низу!",
                    themeColor = Color(0xFFF48FB1)
                )
            )
        ),
        RobloxPlace(
            id = "blox_fruits",
            enName = "Blox Fruits",
            ruName = "Blox Fruits (Блокс Фрутс)",
            enHint = "An action-packed RPG inspired by the famous One Piece anime. Train to become the strongest warrior, raid sea beasts, and consume elemental fruits.",
            ruHint = "Приключенческая RPG по мотивам знаменитого аниме One Piece. Тренируйтесь, чтобы стать сильнее, сражайтесь в море и ешьте магические фрукты.",
            emoji = "🏴‍☠️⚔️🍇",
            themeColor = Color(0xFF1E88E5),
            category = "RPG / Anime",
            difficulty = "Medium",
            scenes = listOf(
                PlaceScene(
                    emoji = "🏴‍☠️⚔️🍇",
                    enHint = "Consuming mythical elemental fruits, grinding levels on island bandits, and fighting alongside your pirate crew.",
                    ruHint = "Поедание мифических стихийных фруктов, гринд уровней на пиратах и исследование островов в поисках новых способностей.",
                    themeColor = Color(0xFF1E88E5)
                ),
                PlaceScene(
                    emoji = "🌊🐺🗡️",
                    enHint = "Fighting gigantic Sea Beasts in the Second Sea, obtaining legendary style swords like Zoro, and awakening your inner power.",
                    ruHint = "Борьба с гигантскими Морскими Зверями во Втором Море, получение легендарных мечей как у Зоро и пробуждение истинной силы.",
                    themeColor = Color(0xFF42A5F5)
                ),
                PlaceScene(
                    emoji = "🏰🔥🔮",
                    enHint = "Attacking massive raid bosses in castles and floating islands to gain custom fragments, mastering Godhuman fighting styles.",
                    ruHint = "Атаки на рейдовых боссов в замках и на летающих островах ради фрагментов, изучение редчайших стилей боя вроде Godhuman.",
                    themeColor = Color(0xFF90CAF9)
                )
            )
        ),
        RobloxPlace(
            id = "murder_mystery_2",
            enName = "Murder Mystery 2",
            ruName = "Murder Mystery 2 (ММ2)",
            enHint = "A tense social deduction game of survival where matching rounds assign roles: Detective Sheriffs, Innocent Civilians, and a sneaky Murderer with a knife.",
            ruHint = "Напряженная игра на выживание и дедукцию, где игрокам тайно даются роли: Шериф с пистолетом, невинные жители и скрытный Убийца с ножом.",
            emoji = "🔪🔫🕵️",
            themeColor = Color(0xFFE53935),
            category = "Survival",
            difficulty = "Easy",
            scenes = listOf(
                PlaceScene(
                    emoji = "🔪🕵️🤫",
                    enHint = "A sneaky killer slowly hunts down civilians in dark halls, while trying to avoid the Sheriff with the golden gun.",
                    ruHint = "Скрытный убийца с ножом выслеживает мирных жителей в темных коридорах, пытаясь избежать выстрела Шерифа.",
                    themeColor = Color(0xFFE53935)
                ),
                PlaceScene(
                    emoji = "🔫🎯🌟",
                    enHint = "The Sheriff drops their revolver, allowing an innocent civilian to pick it up in a dramatic attempt to shoot the active killer!",
                    ruHint = "Шериф роняет свой револьвер, давая невинному жителю подобрать его и сделать спасительный выстрел прямо в маньяка!",
                    themeColor = Color(0xFFEF5350)
                ),
                PlaceScene(
                    emoji = "📦🕶️💎",
                    enHint = "Unboxing colorful neon custom skin knives and guns, showing off your rare items in the lobby before a sneaky round begins.",
                    ruHint = "Открытие кейсов со сверкающими скинами на ножи и пистолеты, а также демонстрация своего редкого инвентаря в лобби перед раундом.",
                    themeColor = Color(0xFFEF9A9A)
                )
            )
        ),
        RobloxPlace(
            id = "royale_high",
            enName = "Royale High",
            ruName = "Royale High (Рояль Хай)",
            enHint = "A magical fantasy academy school where students attend wizard classes, dress up in stunning fairy gowns, collect sparkling crystals, and attend balls.",
            ruHint = "Волшебная академия магии и фантастики, где можно наряжаться в сверкающие королевские платья, посещать уроки, собирать кристаллы и ходить на бал.",
            emoji = "👑✨💎",
            themeColor = Color(0xFF8E24AA),
            category = "Fairy Roleplay",
            difficulty = "Medium",
            scenes = listOf(
                PlaceScene(
                    emoji = "🏰👗💎",
                    enHint = "Dressing up in gigantic, glowing custom gowns, earning shiny diamonds, and flying across the majestic fairy castle.",
                    ruHint = "Примерка бальных платьев, украшенных коронами, фарм сияющих кристаллов и полеты вокруг замка волшебной академии.",
                    themeColor = Color(0xFF8E24AA)
                ),
                PlaceScene(
                    emoji = "📝🎒🩰",
                    enHint = "Attending potion classes, chemistry tests, and art lessons inside a magical high school to level up and win crowns.",
                    ruHint = "Посещение занятий по зельеварению, химии и рисованию в фэнтези-школе ради повышения уровня и новых корон.",
                    themeColor = Color(0xFFAB47BC)
                ),
                PlaceScene(
                    emoji = "🌸🛋️🧸",
                    enHint = "Spicing up your personal sweet castle dorm room with soft fairy curtains, custom plush toys, and pastel tea tables.",
                    ruHint = "Обустройство личной комнаты в общежитии замка пастельной мебелью, мягкими игрушками и чайными столиками.",
                    themeColor = Color(0xFFCE93D8)
                )
            )
        ),
        RobloxPlace(
            id = "arsenal",
            enName = "Arsenal",
            ruName = "Arsenal (Арсенал)",
            enHint = "A lightning-fast tactical FPS game where every elimination cycles through a massive arsenal of weapons, ending with the golden knife.",
            ruHint = "Молниеносный шутер от первого лица, где каждое убийство меняет ваше оружие на совершенно новое из огромного арсенала вплоть до золотого ножа.",
            emoji = "🎯🔫🏆",
            themeColor = Color(0xFF3949AB),
            category = "FPS Shooter",
            difficulty = "Hard",
            scenes = listOf(
                PlaceScene(
                    emoji = "🎯🔫⚡",
                    enHint = "An action gunfight game where each kill immediately swaps your weapon until someone obtains the victorious Golden Knife.",
                    ruHint = "Быстрый шутер, где при каждом килле оружие меняется автоматически, а финал наступает при убийстве золотым ножом.",
                    themeColor = Color(0xFF3949AB)
                ),
                PlaceScene(
                    emoji = "🔪💨🏃",
                    enHint = "Dashing across blocks with a melee knife out for maximum speed, performing funny character dance emotes after a clean win.",
                    ruHint = "Быстрый бег с ножом в руках ради максимального темпа и забавные танцевальные эмодзи после зрелищной победы.",
                    themeColor = Color(0xFF5C6BC0)
                ),
                PlaceScene(
                    emoji = "🗣️🚀💥",
                    enHint = "Using rocket jumps to fly across maps, throwing spellbooks, and listening to the high-energy famous game announcer.",
                    ruHint = "Полеты по карте с помощью рокет-джампа, стрельба из экзотического оружия и прослушивание восторженного комментатора.",
                    themeColor = Color(0xFF9FA8DA)
                )
            )
        ),
        RobloxPlace(
            id = "piggy",
            enName = "Piggy",
            ruName = "Piggy (Пигги)",
            enHint = "An escape-room horror game where you decipher keypad puzzles and gather colorful keys, all while staying clear of an infected, mallet-wielding family.",
            ruHint = "Хоррор-квест, где вам предстоит разгадывать шифры и искать ключи, спасаясь от зараженной семьи свинок во главе с безумной Пигги.",
            emoji = "🐷🔦🔑",
            themeColor = Color(0xFF757575),
            category = "Horror / Escape",
            difficulty = "Medium",
            scenes = listOf(
                PlaceScene(
                    emoji = "🏃🐷🔦",
                    enHint = "Sprinting through a locked house, finding blue and red keys, while dodging a scary pig with glowing eyes and an active baseball bat.",
                    ruHint = "Побег из запертого дома, поиск синего и красного ключей под шаги страшной розовой хрюшки с горящими глазами.",
                    themeColor = Color(0xFF757575)
                ),
                PlaceScene(
                    emoji = "🔑🚪🧪",
                    enHint = "Cracking detailed keypad puzzles and using code cards to unlock experimental laboratory escape hatches in the final safehouse chapter.",
                    ruHint = "Решение кодовых панелей и использование ключ-карт лаборатории, чтобы выбраться из безопасного бункера в финальной главе.",
                    themeColor = Color(0xFF9E9E9E)
                ),
                PlaceScene(
                    emoji = "🎭💀🏚️",
                    enHint = "Uncovering the sad backyard story of infected animal friendly characters while dodging traps placed by the creepy primary pig bot.",
                    ruHint = "Разгадка грустной истории зараженных зверей и уворачивание отпкапканных ловушек, которые расставляет злобный ИИ-бот.",
                    themeColor = Color(0xFFBDBDBD)
                )
            )
        ),
        RobloxPlace(
            id = "bee_swarm",
            enName = "Bee Swarm Simulator",
            ruName = "Bee Swarm Simulator",
            enHint = "A delightful farming game about cultivating a custom hive of friendly bees, traveling across mountain meadows, and satisfying the Honey Bear.",
            ruHint = "Красочный симулятор фермера, где вы разводите пчелиный рой, собираете пыльцу на горных полянах и делаете сладкий мед для Медведя.",
            emoji = "🐝🍯🌻",
            themeColor = Color(0xFFFDD835),
            category = "Simulator",
            difficulty = "Easy",
            scenes = listOf(
                PlaceScene(
                    emoji = "🐝🍯🌻",
                    enHint = "Using a vacuum-like scoop in yellow sunflower fields, collecting sweet pollen, and filling your glowing hive with golden honey.",
                    ruHint = "Сбор пыльцы на ромашковых и подсолнечных полях с помощью сачка и последующее превращение её в сладкий мед у ульев.",
                    themeColor = Color(0xFFFDD835)
                ),
                PlaceScene(
                    emoji = "🐻🎈🛒",
                    enHint = "Completing quests for Science Bear, Panda Bear, and Black Bear to earn tickets, royal jellies, and super silver eggs.",
                    ruHint = "Выполнение квестов Научного Медведя, Панды и Черного Медведя ради получения ценного билетика, маточного молочка или серебряного яйца.",
                    themeColor = Color(0xFFFEE082)
                ),
                PlaceScene(
                    emoji = "🐞⚔️🍯",
                    enHint = "Commanding your army of custom bees including Ninja, Commander, and Rage bees to protect you from level-based giant ladybugs and spiders.",
                    ruHint = "Управление роем особых пчел (Ниндзя, Командир, Яростная) для защиты от уровня божьих коровок и гигантских пауков.",
                    themeColor = Color(0xFFFFF59D)
                )
            )
        ),
        RobloxPlace(
            id = "pet_sim",
            enName = "Pet Simulator 99",
            ruName = "Pet Simulator 99 (Пет Сим 99)",
            enHint = "The ultimate clicking tycoon. Break vaults, collect billions of gold coins, discover enchanted islands, and hatch gigantic, shiny pets.",
            ruHint = "Кликер-тайкун, в котором вы разбиваете сейфы, собираете миллиарды золотых монет, открываете новые миры и выращиваете гигантских питомцев.",
            emoji = "🪙🐱⭐",
            themeColor = Color(0xFF00B0FF),
            category = "Tycoon / Clicker",
            difficulty = "Easy",
            scenes = listOf(
                PlaceScene(
                    emoji = "🪙🐱🧲",
                    enHint = "Deploying an army of cute blocky square animals to break piles of gold coins and diamond chests in massive colorful zones.",
                    ruHint = "Призыв целой армии квадратных питомцев для разбивания куч золотых монет и сундуков в бесконечных разноцветных биомах.",
                    themeColor = Color(0xFF00B0FF)
                ),
                PlaceScene(
                    emoji = "🏰🎁💎",
                    enHint = "Unlocking the giant spinning reward wheel in the castle, upgrading your pet magnets, and purchasing lucky egg hatching passes.",
                    ruHint = "Разблокировка колеса фортуны в замке, прокачка силы магнита и покупка пропусков на удачное вылупление огромных яиц.",
                    themeColor = Color(0xFF40C4FF)
                ),
                PlaceScene(
                    emoji = "🦄🐠🦖",
                    enHint = "Trading huge, shiny, and rainbow-colored pets in the active trading plaza to complete your custom collection of index levels.",
                    ruHint = "Торговля огромными, светящимися и радужными питомцами на оживленной торговой площади, чтобы собрать полную коллекцию индекса.",
                    themeColor = Color(0xFF80D8FF)
                )
            )
        ),
        RobloxPlace(
            id = "bedwars",
            enName = "BedWars",
            ruName = "BedWars (БедВарс)",
            enHint = "A strategic team action battle where teams defend their respawn bed, gather iron/diamonds, upgrade equipment, and destroy enemy bases.",
            ruHint = "Командная стратегическая PVP игра, где нужно собирать ресурсы, улучшать броню, защищать свою кровать и ломать спавны противников.",
            emoji = "🛏️⚔️🛡️",
            themeColor = Color(0xFF1565C0),
            category = "PVP / Action",
            difficulty = "Hard",
            scenes = listOf(
                PlaceScene(
                    emoji = "🛏️⚔️🧗",
                    enHint = "Sprinting across sky-high paths of wool blocks, preparing emerald armor, and guarding your team's bed with obsidian structures.",
                    ruHint = "Бег по мостам из цветной шерсти над бездной, сбор изумрудов на броню и защита своей кровати слоями обсидиана.",
                    themeColor = Color(0xFF1565C0)
                ),
                PlaceScene(
                    emoji = "💎🏹🐉",
                    enHint = "Rushing generator generators for diamonds, upgrading team damage, and firing wind bows or explosive balloons at active rushers.",
                    ruHint = "Раш генераторов алмазов, прокачка урона команды и обстрел противников из ветряного лука или взрывающимися шарами.",
                    themeColor = Color(0xFF1E88E5)
                ),
                PlaceScene(
                    emoji = "🦊🔮🗡️",
                    enHint = "Picking unique hero kits like Elder, Yuzi, or Vulcan to spawn custom weapons, turrets, or teleport skills during combat.",
                    ruHint = "Выбор уникальных наборов героев (Эльдер, Юзи, Вулкан) для создания кастомных турелей, телепортов или супер-ударов.",
                    themeColor = Color(0xFF64B5F6)
                )
            )
        ),
        RobloxPlace(
            id = "doors",
            enName = "Doors",
            ruName = "Doors (Двери)",
            enHint = "A terrifying stealth maze where you navigate room-by-room, avoiding visual cues of monsters like Rush, Screech, Seek, and Figure in a creaky old hotel.",
            ruHint = "Атмосферный хоррор-стелс, где нужно скрытно проходить комнаты отеля, спасаясь от жутких сущностей: Раша, Сика, Скрича и Фигуры.",
            emoji = "🚪👁️🔑",
            themeColor = Color(0xFF37474F),
            category = "Horror / Puzzle",
            difficulty = "Medium",
            scenes = listOf(
                PlaceScene(
                    emoji = "🚪🏨👁️",
                    enHint = "Creeping room by room through a haunting hotel. Lights flicker, signaling you to find a locker before a loud screaming beast crashes by!",
                    ruHint = "Прохождение жутких комнат отеля. Свет мигает, предупреждая, что пора искать шкаф, пока через коридор не пронесся жуткий Раш!",
                    themeColor = Color(0xFF37474F)
                ),
                PlaceScene(
                    emoji = "🤫📚👂",
                    enHint = "Sneaking quietly in the library to collect code-filled books while dodging a blind, tall monster that tracks your heartbeat!",
                    ruHint = "Бесшумный обход библиотеки, сбор книг по подсказкам, спасаясь от слепого высокого монстра, слышащего стук твоего сердца!",
                    themeColor = Color(0xFF455A64)
                ),
                PlaceScene(
                    emoji = "🏃‍♂️🕶️🚪",
                    enHint = "A dramatic chase sequence running through eyes-infested corridors, sliding under wooden planks as a black fluid creature hunts you!",
                    ruHint = "Зрелищная погоня в длинном коридоре полном глаз, подкаты под досками под музыку преследования черного склизкого Сика!",
                    themeColor = Color(0xFF90A4AE)
                )
            )
        )
    )
}
