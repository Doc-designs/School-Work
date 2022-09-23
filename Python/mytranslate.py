EtoSBasicDic = {"car":"carro", "for":"por", "watch":"reloj", "time":"tiempo","she drive":
"maneja", "he drive":"maneja", "they drive":"manejan", "we drive":"manejamos",
"you drive":"manejas", "i drive":"manejo", "they go":"van",
"we go":"vamos", "you go":"vas", "you go":"va","i go":"voy","evening":"noche",
"afternoon":"tarde","morning":"manana","twelve o'clock":"a las doce", "eleven o'clock":"a las once",
"ten o'clock":"a las diez", "nine o'clock":"a las nueve", "eight o'clock":"a las ocho",
"seven o'clock":"a las siete", "six o'clock":"a las seis", "five o'clock":"a las cinco",
"four o'clock":"a las cuatro", "three o'clock":"a las tres", "two o'clock":"a las dos",
"one o'clock":"a la uno", "she leave":"salga","he leave":"salga","they leave":"salgan",
"we leave":"salgamos", "you leave":"salga", "you leave":"sagas", "i leave":"salgo",
"she arrive":"llega", "he arrive":"llega", "they arrive":"llegan","we arrive":"llagamos",
"you arrive":"llega", "i arrive":"llego","block":"cuadrantes",
"north":"norte","south":"sur","west":"oeste","east":"este","ocean":"mar","boat":"barco",
"she pay":"paga", "he pay":"paga","we pay":"pagamos", "they pay":"pagan",
"you pay":"pagas", "i pay":"pago","fare":"tarifa","postcard":"tarjeta postal",
"phone":"telefono", "camera":"camara","ticket":"boleta","tourist":"turista",
"welcome":"bievenides","she travel":"viaje","he travel":"viaje","they travel":"viajen",
"we travel":"viajamos","you travel":"viaje","i travel":"viajo", "school":"escuela",
"vacation":"vacacion","work":"trabajo","home":"casa","destination":"destinacion",
"passenger":"pasajero","drive":"manejar","airplane":"avion","she walk":"camina",
"he walk":"camina","they walk":"caminan","we walk":"caminamos","you walk":"camina",
"you walk":"caminas","i walk":"camino","walk":"caminar","bicycle":"bicicleta","ferry":"fere",
"train":"tren","subway":"subterraneo","they":["ellos", "ellas"],"to the":["al", "a la"],
"the":["el", "la"], "from":"de","you":"tu", "to":"a","we":"nosotros","i":"yo"}
#GenderDict
MascFem = {"carro": 0, "reloj": 0, "tiempo": 0,"maneja": 1, "manejan": 1, "manejamos": 0,
"manejas": 1, "manejo": 0, "van": 1,"vamos": 0, "vas": 1, "va": 1,
"voy": 0,"noche": 0, "tarde": 1,"manana": 1,"a las doce": 1, 
"a las once": 1,"a las diez": 1, "a las nueve": 1, "a las ocho": 1,
"a las siete": 1,"a las seis": 1,"a las cinco": 1, "a las cuatro": 1,"a las tres": 1,
 "a las dos": 1, "a la uno": 1, "salga": 1,"salgan": 1,"salgamos": 0, 
"salga": 1,"sagas": 1,"salgo": 0,"llega": 1, "llegan": 1,"llagamos": 0,"llega": 1,
"llego": 0,"cuadrantes": 1,"norte": 0,"sur": 0,"oeste": 0,"este": 0,"mar": 1,"barco": 0,
"paga": 1,"pagamos": 0,"pagan": 1,"pagas": 1, "pago": 0,"tarifa": 1,"tarjeta postal": 1,
"telefono": 0, "camara": 1,"boleta": 1,"turista": 1,"bievenides": 0,"viaje": 1,"viajen": 1,
"viajamos": 0,"viaje": 1,"viajo": 0,"escuela": 1,"vacacion": 1,"trabajo": 0,"casa": 1,
"destinacion": 0,"pasajero": 0,"manejar": 1,"avion": 0,"camina": 1,"caminan": 1,"caminamos": 0,
"camina": 1,"caminas": 1,"camino": 0,"caminar": 1,"bicicleta": 1,"fere": 0,"tren": 0,"subterraneo": 0}
#function to fix improperly split elements
def listFix(breakdown):
    #combining two element words, needed variables
    #ends while loop, avoiding for loop due to changing list length
    ende = False
    #itteration counter
    ittModi = 0
    #combining element loop
    while ende == False:
        #if on last list element
        if breakdown[ittModi] == breakdown[-1]:
            ende = True
        else:
            #if current element + next element is in dictionary
            if breakdown[ittModi] + " " + breakdown[ittModi + 1] in EtoSBasicDic:
                #modifies current element into dictionary element
                breakdown[ittModi] += " " + breakdown[ittModi + 1]
                #removes next element
                breakdown.pop(ittModi+1)
            elif breakdown[ittModi] + " " + breakdown[ittModi + 1][:-1] in EtoSBasicDic:
                #modifies current element into dictionary element
                breakdown[ittModi] += " " + breakdown[ittModi + 1]
                #removes next element
                breakdown.pop(ittModi+1)
            else:
                #otherwise increases itteration
                ittModi += 1
    return breakdown
#GenderSetter
def genderSet(breakdown):
    #return of function
    retlist = [0]
    #current sentence
    currentSent = 0
    #loop through list of words
    for i in range(len(breakdown)):
        #for each eng word in dict
        for key in EtoSBasicDic:
            #if eng word is within current phrase word, and does not have list value in dictionary
            if key in breakdown[i] and type(EtoSBasicDic.get(key)) != list:
                #if current word has assigned gender
                if EtoSBasicDic.get(key) in MascFem:
                    #if masc
                    if MascFem.get(EtoSBasicDic.get(key)) == 0:
                        #set current sentence to masc
                        retlist[currentSent] = 0
                        #if end of sentence
                        if breakdown[i][-1] == ".":
                            #set to next sentence in list of sentence gender
                            currentSent += 1
                            #increase sentence gender list size
                            retlist.append(0)
                        #break key loop
                        break
                    #if fem
                    elif MascFem.get(EtoSBasicDic.get(key)) == 1:
                        #set current sentence to fem
                        retlist[currentSent] = 1
                        #if end of sentence
                        if breakdown[i][-1] == ".":
                            #set to next sentence in list of sentence gender
                            currentSent += 1
                            #increase sentence gender list size
                            retlist.append(0)
                        #break key loop
                        break
    return retlist
                
#Designed for Present Tense only
def eng_to_span(phrase):
    #return phrase
    newphrase = ""
    #current word being translated
    currentword = ""
    #sets words into a list as lower case
    breakdown = phrase.lower().split()
    #function to fix errors in list split
    breakdown = listFix(breakdown)
    #determines gender of dictionary values that are lists
    gender = genderSet(breakdown)
    #current sentence, used to check sentence gender
    currentGen = 0
    #loop through words in phrase
    for i in range(len(breakdown)):
        #if element in dictionary is true
        if breakdown[i] in EtoSBasicDic:
            #set a current word
            currentword = breakdown[i]
            #if word value is list
            if type(EtoSBasicDic.get(currentword)) == list:
                #choose sentence gender
                if gender[currentGen] == 0:
                    #addition to return phrase
                    newphrase += EtoSBasicDic.get(currentword)[0] + " "
                else:
                    #addition to return phrase
                    newphrase += EtoSBasicDic.get(currentword)[1] + " "
            else:
                #add its dictionary spanish counterpart to new phrase
                newphrase += EtoSBasicDic.get(currentword) + " "
        #if word is within element in list
        else:
            #loops through english strings in dict
            for key in EtoSBasicDic:
                #if key within current word
                if key in breakdown[i]:
                    #if last character is . and dict value is list
                    if breakdown[i][-1] == "." and type(EtoSBasicDic.get(key)) == list:
                        if gender[currentGen] == 0:
                            #add on the period
                            newphrase += EtoSBasicDic.get(key)[0] + "." + " "
                            #new sentence
                            currentGen += 1
                        else:
                            #add on the period
                            newphrase += EtoSBasicDic.get(key)[1] + "." + " "
                            #new sentence
                            currentGen += 1
                        #break key loop
                        break
                    #only if last character is .
                    elif breakdown[i][-1] == ".":
                        #add word to phrase, then add period
                        newphrase += EtoSBasicDic.get(key) + "." + " "
                        #new sentence
                        currentGen += 1
                        #break key loop
                        break
                    #if not end of sentence
                    else:
                        #if word value is list
                        if type(EtoSBasicDic.get(key)) == list:
                            #if masc
                            if gender[currentGen] == 0:
                                #add masc version to phrase
                                newphrase += EtoSBasicDic.get(key)[0] + " "
                            #if fem
                            else:
                                #add fem version to phrase
                                newphrase += EtoSBasicDic.get(key)[1] + " "
                            #break key loop
                            break
                        #if normal string value
                        else:
                            #add it to the phrase
                            newphrase += EtoSBasicDic.get(key) + " "
                            #break key loop
                            break
    #returns modified phrase
    return newphrase
        

if __name__ == "__main__":
    print(eng_to_span("you drive to the ferry. I drive to the home."))