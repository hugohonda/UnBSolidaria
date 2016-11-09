package br.unb.unbsolidaria.persistencia;

import java.util.Arrays;
import java.util.List;

import br.unb.unbsolidaria.entidades.Oportunidade;
import br.unb.unbsolidaria.entidades.Organizacao;
import br.unb.unbsolidaria.entidades.Tags;
import br.unb.unbsolidaria.entidades.Voluntario;

/**
 * Created by hugohonda on 02/11/16.
 */

public class BancoDeDados {
    private static BancoDeDados instance;
    private List<Voluntario> voluntarios;
    private List<Organizacao> organizacoes;
    private List<Tags> tags;
    private List<Oportunidade> oportunidades;

    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    Calendar c = Calendar.getInstance();

    private BancoDeDados () {
    	/*int id, String cpf, String nome, String sobrenome, Calendar dataNascimento, String email, String telefone,
        String descricao, String matricula, String endereco, String sexo, boolean ativo*/
        voluntarios = Arrays.asList(
                new Voluntario(0, "968.551.756-86", "Otávio", "Barros Fernandes", getCalendar("05/07/1991") , "OtavioBarrosFernandes@teleworm.us", "(61) 3186-9880",
                					/* Descrição */, "12/0136867", "Rua do Pontal, 1394, Samambaia-DF", "M", true),
                new Voluntario(1, "848.372.290-93", "André", "Barbosa Melo", getCalendar("22/11/1994") , "AndreBarbosaMelo@rhyta.com", "(61) 998301-6297",
                					/* Descrição */, "13/0075893", "Rua Doutor José Leite Pinheiro, 1480, Taguatinga-DF", "M", true),
                new Voluntario(2, "307.784.202-56", "Murilo", "Correia Melo", getCalendar("09/01/1995"), "MuriloCorreiaMelo@dayrep.com", "(61) 3853-8649",
                					/* Descrição */, "15/0067848", "Quadra QE 38 Conjunto E1, Guara II - DF", "M", true),
                new Voluntario(3, "905.107.888-90", "Matilde", "Barbosa Barros", getCalendar("13/04/1997"), "MatildeBarbosaBarros@armyspy.com", "(61) 99663-6149",
                					/* Descrição */, "14/0183112", "Quadra 36 Conjunto C, Brazlandia - DF", "F", true),
                new Voluntario(4, "909.543.331-52", "Rebeca", "Pereira Rocha", getCalendar("04/10/1996"), "RebecaPereiraRocha@rhyta.com", "(61) 98987-8082",
                					/* Descrição */, "13/0189467", "Quadra QI 2 Conjunto F, Guara I - DF", "F", true)
                );
        /*int mId, String mCnpj, String mNomeJuridico, String mNomeComercial, String mEmail, String mTelefone, 
        String mWebSite, String mDescricao, String mEndereco, String mCep*/
        organizacoes = Arrays.asList(
                new Organizacao(0, "79.214.237/0001-25","César e Felipe Marcenaria Ltda", "CF Marcenaria", "pesquisa@cesarfelipe.com.br", "(61) 2906-0035",
                					"www.cesarfelipe.com.br", /* Descrição */, "Condomínio Residencial 833, Candangolândia - DF", "71725-020"),
                new Organizacao(1, "91.416.099/0001-62", "LE Contábil ME", "LE Contabil", "rh@le.com.br", "(61) 3620-6873", 
                					"www.le.com.br", /* Descrição */, "Quadra QR 511 Conjunto 13 983, Samambaia-DF", "(61) 3620-6873").
                new Organizacao(2, )
                );
        /*String mId, String mNome, String mDescricao*/
        tags = Arrays.asList(
                new Tags(0, "Marcenaria", "Trabalhos com madeira"),
                new Tags(1, "Informática", "Trablhos de programação"),
                new Tags(2, "Educação", "Trabalhos para dar aulas"),
                new Tags(3, "Caridade", "Trabalhos de ajuda aos pobres"),
                new Tags(4, "Sustentabilidade", "Trabalhos de caráter ambiental"),
                new Tags(5, "Gênero", "Trabalhos com foco em questões de gênero"),
                new Tags(6, "Design", "Trabalhos de criação visual"),
                new Tags(7, "Arquitetura", "Trabalhos com empresas de arquiteura"),
                new Tags(8, "Saúde", "Trabalhos em hospitais, ou áreas da saúde"),
                new Tags(9, "Animais", "Trablhos com animais")
        );
        /*int mID, String mLocal, int mVagas, String mTitulo, String mDescricao, Calendar mInicio, Calendar mFim, Organizacao org*/
        oportunidades = Arrays.asList(
                new Oportunidade(),
                new Oportunidade()
        );
    }

    private Calenadar getCalendar(String data){
    	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    	Calendar c = Calendar.getInstance();
    	c.setTime(formatoData.parse(data);
    	return c;
    }

    public static BancoDeDados getInstance(){
        if(instance == null){
            instance = new BancoDeDados();
        }
        return instance;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public List<Organizacao> getOrganizacoes() {
        return organizacoes;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }
}
