<#ftl encoding="utf-8">


<body xmlns="http://www.w3.org/1999/html">
 <h1>Espace élèves</h1>

      <p>Espace modification élève</p>
        <form action="/eleves/modify" method="post">
        
        <label for="id">Identifiant de l'élève</label>
        <br/><br/>
        <select name="id" required >
            <#list eleves as eleve>
                <option value=${eleve.id}>${eleve.id}</option>
            </#list>
        </select>

        <br/><br/>
        <div>Nouveau prénom de l'élève :</div>
        <input type="text" name="firstname" required/>
        <br/><br/>
        <div>Nouveau nom de l'élève :</div>
        <input type="text" name="lastname" required/>
        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
    
    <a href="/eleves"> Retour à la page précédente</a> <br/>


</body>

</html>

