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
                					/* Descrição */, "13/0189467", "Quadra QI 2 Conjunto F, Guara I - DF", "F", true),
                new Voluntario(5, "708.788.307-07", "Eduarda", "Cavalcanti Melo", getCalendar("29/10/1995"), "EduardaCavalcantiMelo@gmail.com", "(61) 99390-0359",
                					/* Descrição */,"14/0138490", "Vila Nova, São Sebastião - DF", "F", true),
                new Voluntario(6, "896.355.071-00", "Antônio", "Fernandes Costa", getCalendar("23/01/1998"), "AntonioFernandesCosta@jourrapide.com", "(61) 98645-4569",
                					/* Descrição */,"16/0104456", "Quadra QI 4 Conjunto L, Gama - DF", "M", true),
                new Voluntario(7, "476.397.431-92", "Luan", "Araujo Oliveira", getCalendar("15/06/1996"), "LuanAraujoOliveira@rhyta.com", "(61) 98765-5678",
                					/* Descrição */,"15/0163277", "Quadra EQN 212/213, Asa Norte - DF", "M", true),
                new Voluntario(8, "440.621.631-60", "Leila", "Santos Alves", getCalendar("13/03/1993"), "LeilaSantosAlves@jourrapide.com", "(61) 98089-9363",
                					/* Descrição */,"13/0193480", "Quadra SQN 412 Bloco R, Asa Norte - DF", "F", true),
                new Voluntario(8, "902.632.931-81", "Marisa", "Oliveira Martins", getCalendar("22/05/1994"), "MarisaOliveiraMartins@teleworm.us", "(61) 98834-3880",
                					/* Descrição */,"13/0172394", "Rua 4 Chácara 32, Vicente Pires - DF", "F", true),
                new Voluntario(9, "048.375.511-73", "Nicole", "Goncalves Sousa", getCalendar("18/07/1990"), "NicoleGoncalvesSousa@jourrapide.com", "(61) 98541-5843",
                					/* Descrição */,"10/0025651", "Setor de Chácaras Córrego da Onça Rua D Chácara 9, Núcleo Bandeirante - DF", "F", true),
                new Voluntario(10, "604.386.149-68", "Vitória", "Cardoso Oliveira", getCalendar("24/08/1994"), "VitoriaCardosoOliveira@armyspy.com", "(61) 98260-2984",
                					/* Descrição */,"16/0153278", "Avenida Central Conjunto 2, Sobradinho II - DF", "F", true),
				new Voluntario(11, "568.725.541-93", "Cauã", "Oliveira Lima", getCalendar("08/01/1996"), "CauaOliveiraLima@dayrep.com", "(61) 98093-3967",
                					/* Descrição */,"14/0189347", "Quadra SQN 111 Bloco F, 320, Brasília - DF", "M", true),
				new Voluntario(12, "819.217.271-60", "Breno", "Fernandes Dias", getCalendar("04/12/1994"), "BrenoFernandesDias@armyspy.com", "(61) 98540-8934",
                					/* Descrição */,"14/0198031", "Quadra CLN 7 Bloco K, Riacho Fundo I - DF", "M", true),
				new Voluntario(13, "554.393.631-14", "Isabela", "Souza Cavalcanti", getCalendar("17/09/1997"), "IsabelaSouzaCavalcanti@teleworm.us", "(61) 97491-8345",
                					/* Descrição */,"15/0074913", "Quadra SHCGN 710 Bloco F, Asa Norte - DF", "F", true),
				new Voluntario(14, "164.444.891-21", "Davi", "Dias Cavalcanti", getCalendar("19/11/1992"), "DaviDiasCavalcanti@teleworm.us", "(61) 99897-3428",
                					/* Descrição */,"09/0132490", "Quadra QS 5 Rua 820, Águas Claras - DF", "M", true),
				new Voluntario(15, "296.323.001-06", "Marcos", "Dias Castro", getCalendar("01/01/1991"), "MarcosDiasCastro@armyspy.com", "(61) 99497-4840",
                					/* Descrição */,"10/0182370", "Quadra SGAN 609 Módulo B, Asa Norte - DF", "M", true),
				new Voluntario(16, "959.019.181-93", "Vitoria", "Martins Rodrigues", getCalendar("02/09/1998"), "VitoriaMartinsRodrigues@rhyta.com", "(61) 98754-4333",
                					/* Descrição */,"16/0020004", "Quadra CLNW 6/7 Lote F, Setor Noroeste - DF", "F", true),
				new Voluntario(17, "369.084.061-99", "Mariana", "Martins Castro", getCalendar("06/05/1997"), "MarianaMartinsCastro@dayrep.com", "(61) 98479-9999",
                					/* Descrição */,"14/0164982", "Quadra EQNO 11/13 Bloco D, Ceilândia - DF", "F", true),
				new Voluntario(18, "881.528.161-40", "Guilherme", "Oliveira Pereira", getCalendar("15/07/1994"), "GuilhermeOliveiraPereira@teleworm.us", "(61) 99975-2222",
                					/* Descrição */,"14/0024798", "Quadra CLS 210 Bloco A, Asa Sul - DF", "M", true),
				new Voluntario(19, "095.392.391-68", "Vinícius", "Pereira Castro", getCalendar("21/05/1994"), "ViniciusPereiraCastro@rhyta.com", "(61) 92427-3487",
                					/* Descrição */,"11/0155788", "Quadra 105 Bloco D, Cruzeiro Novo - DF", "M", true),
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
