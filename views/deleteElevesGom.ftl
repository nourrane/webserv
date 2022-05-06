<#ftl encoding="utf-8">


<body xmlns="http://www.w3.org/1999/html">
 <h1>Espace des attributions des gommettes à un élève</h1>

         <p>Espace suppression d'une gommette à un élève</p>
        <form action="/elevesGom/delete" method="post">

        <div>Identifiant de l'attribution de la gommette à un élève :</div>
        <select name="id" required >
            <#list eleveGom as eg>
                <option value=${eg.id}>${eg.id}</option>
            </#list>
        </select>
        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
    <a href="http://localhost:8081/elevesGom"> Retour à la page précédente</a> <br/>

</body>

</html>

