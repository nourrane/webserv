<#ftl encoding="utf-8">


<body xmlns="http://www.w3.org/1999/html">

 <h1>Espace élèves</h1>

    <p>Espace de recherche d'un élève pour voir ces gommettes</p>
        <form action="/elevesGom/recherche" method="post">


        <label for="idEleve">Identifiant de l'élève</label>
        <br/><br/>
        <select name="idEleve" required >
            <#list eleves as eleve>
                <option value=${eleve.id}>${eleve.id}</option>
            </#list>
        </select>

        <br/><br/>
    <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>

    


  <#if eleveChoisi??>
  <p> Liste de gommette de l'eleve ${eleveChoisi.id}: ${eleveChoisi.firstName} ${eleveChoisi.lastName} </p>
         <ul>
    <#list eleveGomSpe as e>
        <li>Attribution :${e.id} id de la gommettes: ${e.idGom}  -- couleur gommettes: ${e.color}
        -- motif gommettes: ${e.motif}</li>
    </#list>
</ul>
         </#if>

 
       
</body>

</html>