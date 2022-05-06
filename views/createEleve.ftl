<#ftl encoding="utf-8">


<body xmlns="http://www.w3.org/1999/html">

 <h1>Espace élèves</h1>

    <p>Espace ajout élève</p>
        <form action="/eleves/create" method="post">

        <div>Prénom de l'élève :</div>
        <input type="text" name="firstname" required/>
        <br/><br/>
        <div>Nom de l'élève :</div>
        <input type="text" name="lastname" required/>
        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
    <a href="/eleves"> Retour à la page précédente</a> <br/>

</body>

</html>