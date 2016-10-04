# Android App - UnB Solidária
Aplicativo Android - Projeto UnB Solidária - Linguagens de Programação - 2/2016 - Universidade de Brasília


##To-Do

- [x] Responder [Doodle](http://doodle.com/poll/q3wri9rb37g4ywh6) para a Reunião Semanal
- [x] Instalar o [Android Studio](https://developer.android.com/studio/index.html)
- [x] Configurar GitHub de acordo com o Guia Básico abaixo
- [ ] Implementar Front Cadastro Voluntário
- [ ] Implementar Front Cadastro Organização
- [ ] Implementar página inicial de Ofertas de Trabalhos ao Voluntário

##Code Style a ser seguido:

[Code Style for Contributors](https://source.android.com/source/code-style.html)

## Guia Básico Git

###Configuração prévia:
* Instale o Git no seu computador
* Clone o repositório para o seu computador:
```
git clone https://github.com/hugohonda/android_app_UnBSolidaria.git
```

Trabalhando com Branches:

###_Branches_ (Ramos):
* _Branches_ são caminhos que você pode criar no código
* Git permite mesclar ramos
* Basicamente: se você quer criar uma nova funcionalidade, crie em um novo ramo - pois esta nova funcionalidade ainda não foi aprovada pelo resto da equipe. Assim você pode trabalhar na nova ideia de forma que as funcionalidades antigas permançam intactas em um _branch_ separado. Se sua implementação for aprovada, será feito um _merge_ do seu ramo com o original (_master_) para que ele receba a nova funcionalidade.

Para verificar a lista de ramos e o ramo atual que você está trabalhando, execute:
```
git branch
```
Para criar um Branch e já começar a usá-lo:
```
git checkout -b [nome_do_branch]
```

###_Merge_
Um dos membros da equipe ficará responsável pelo _merge_
* Funcionalidade são separadas em Branches de cada um e serão _merged_ com o _master branch_
 

###Créditos
* [getting-started-git-team-environment](https://www.sitepoint.com/getting-started-git-team-environment/)
