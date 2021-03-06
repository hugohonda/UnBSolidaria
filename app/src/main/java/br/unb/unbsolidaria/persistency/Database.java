package br.unb.unbsolidaria.persistency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.unb.unbsolidaria.R;
import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.entities.Organization;
import br.unb.unbsolidaria.entities.Tag;
import br.unb.unbsolidaria.entities.Voluntary;

/**
 * Created by hugohonda on 02/11/16.
 */

public class Database {
    private static Database instance;
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    Calendar c = Calendar.getInstance();
    private List<Voluntary> voluntaries;
    private List<Organization> organizacoes;
    private List<Tag> tags;
    private List<Opportunity> opportunities;


    private Database() {
        voluntaries = Arrays.asList(
                new Voluntary(0, "968.551.756-86", "Otávio", "Barros Fernandes", getCalendar("05/07/1991"), "OtavioBarrosFernandes@teleworm.us", "(61) 3186-9880",
                        "Estudante de Engenharia de Produção", "12/0136867", "Rua do Pontal, 1394, Samambaia-DF", "M", true),
                new Voluntary(1, "848.372.290-93", "André", "Barbosa Melo", getCalendar("22/11/1994"), "AndreBarbosaMelo@rhyta.com", "(61) 998301-6297",
                        "Estudante de Pedagogia", "13/0075893", "Rua Doutor José Leite Pinheiro, 1480, Taguatinga-DF", "M", true),
                new Voluntary(2, "307.784.202-56", "Murilo", "Correia Melo", getCalendar("09/01/1995"), "MuriloCorreiaMelo@dayrep.com", "(61) 3853-8649",
                        "Estudante de Direito", "15/0067848", "Quadra QE 38 Conjunto E1, Guara II - DF", "M", true),
                new Voluntary(3, "905.107.888-90", "Matilde", "Barbosa Barros", getCalendar("13/04/1997"), "MatildeBarbosaBarros@armyspy.com", "(61) 99663-6149",
                        "Estudante de Medicina", "14/0183112", "Quadra 36 Conjunto C, Brazlandia - DF", "F", true),
                new Voluntary(4, "909.543.331-52", "Rebeca", "Pereira Rocha", getCalendar("04/10/1996"), "RebecaPereiraRocha@rhyta.com", "(61) 98987-8082",
                        "Estudante de Ciencia da Computação", "13/0189467", "Quadra QI 2 Conjunto F, Guara I - DF", "F", true),
                new Voluntary(5, "708.788.307-07", "Eduarda", "Cavalcanti Melo", getCalendar("29/10/1995"), "EduardaCavalcantiMelo@gmail.com", "(61) 99390-0359",
                        "Estudante de Enegnharia Civil", "14/0138490", "Vila Nova, São Sebastião - DF", "F", true),
                new Voluntary(6, "896.355.071-00", "Antônio", "Fernandes Costa", getCalendar("23/01/1998"), "AntonioFernandesCosta@jourrapide.com", "(61) 98645-4569",
                        "Estudante de Engenharias", "16/0104456", "Quadra QI 4 Conjunto L, Gama - DF", "M", true),
                new Voluntary(7, "476.397.431-92", "Luan", "Araujo Oliveira", getCalendar("15/06/1996"), "LuanAraujoOliveira@rhyta.com", "(61) 98765-5678",
                        "Estudante de Ciencias Politicas", "15/0163277", "Quadra EQN 212/213, Asa Norte - DF", "M", true),
                new Voluntary(8, "440.621.631-60", "Leila", "Santos Alves", getCalendar("13/03/1993"), "LeilaSantosAlves@jourrapide.com", "(61) 98089-9363",
                        "Estudante de Ciencia da Computação", "13/0193480", "Quadra SQN 412 Bloco R, Asa Norte - DF", "F", true),
                new Voluntary(8, "902.632.931-81", "Marisa", "Oliveira Martins", getCalendar("22/05/1994"), "MarisaOliveiraMartins@teleworm.us", "(61) 98834-3880",
                        "Estudante de Educação Física", "13/0172394", "Rua 4 Chácara 32, Vicente Pires - DF", "F", true),
                new Voluntary(9, "048.375.511-73", "Nicole", "Goncalves Sousa", getCalendar("18/07/1990"), "NicoleGoncalvesSousa@jourrapide.com", "(61) 98541-5843",
                        "Estudante de Biologia", "10/0025651", "Setor de Chácaras Córrego da Onça Rua D Chácara 9, Núcleo Bandeirante - DF", "F", true),
                new Voluntary(10, "604.386.149-68", "Vitória", "Cardoso Oliveira", getCalendar("24/08/1994"), "VitoriaCardosoOliveira@armyspy.com", "(61) 98260-2984",
                        "Estudante de Sociologia", "16/0153278", "Avenida Central Conjunto 2, Sobradinho II - DF", "F", true),
                new Voluntary(11, "568.725.541-93", "Cauã", "Oliveira Lima", getCalendar("08/01/1996"), "CauaOliveiraLima@dayrep.com", "(61) 98093-3967",
                        "Estudante de Agronomia", "14/0189347", "Quadra SQN 111 Bloco F, 320, Brasília - DF", "M", true),
                new Voluntary(12, "819.217.271-60", "Breno", "Fernandes Dias", getCalendar("04/12/1994"), "BrenoFernandesDias@armyspy.com", "(61) 98540-8934",
                        "Estudante de Engenharia Mecatrônica", "14/0198031", "Quadra CLN 7 Bloco K, Riacho Fundo I - DF", "M", true),
                new Voluntary(13, "554.393.631-14", "Isabela", "Souza Cavalcanti", getCalendar("17/09/1997"), "IsabelaSouzaCavalcanti@teleworm.us", "(61) 97491-8345",
                        "Estudante de Engenharia Ambiental", "15/0074913", "Quadra SHCGN 710 Bloco F, Asa Norte - DF", "F", true),
                new Voluntary(14, "164.444.891-21", "Davi", "Dias Cavalcanti", getCalendar("19/11/1992"), "DaviDiasCavalcanti@teleworm.us", "(61) 99897-3428",
                        "Estudante de Engenharia Florestal", "09/0132490", "Quadra QS 5 Rua 820, Águas Claras - DF", "M", true),
                new Voluntary(15, "296.323.001-06", "Marcos", "Dias Castro", getCalendar("01/01/1991"), "MarcosDiasCastro@armyspy.com", "(61) 99497-4840",
                        "Estudante de Comunicação", "10/0182370", "Quadra SGAN 609 Módulo B, Asa Norte - DF", "M", true),
                new Voluntary(16, "959.019.181-93", "Vitoria", "Martins Rodrigues", getCalendar("02/09/1998"), "VitoriaMartinsRodrigues@rhyta.com", "(61) 98754-4333",
                        "Estudante de Serviço Social", "16/0020004", "Quadra CLNW 6/7 Lote F, Setor Noroeste - DF", "F", true),
                new Voluntary(17, "369.084.061-99", "Mariana", "Martins Castro", getCalendar("06/05/1997"), "MarianaMartinsCastro@dayrep.com", "(61) 98479-9999",
                        "Estudante de Relações Internacionais", "14/0164982", "Quadra EQNO 11/13 Bloco D, Ceilândia - DF", "F", true),
                new Voluntary(18, "881.528.161-40", "Guilherme", "Oliveira Pereira", getCalendar("15/07/1994"), "GuilhermeOliveiraPereira@teleworm.us", "(61) 99975-2222",
                        "Estudante de Física", "14/0024798", "Quadra CLS 210 Bloco A, Asa Sul - DF", "M", true),
                new Voluntary(19, "095.392.391-68", "Vinícius", "Pereira Castro", getCalendar("21/05/1994"), "ViniciusPereiraCastro@rhyta.com", "(61) 92427-3487",
                        "Estudante de Matemática", "11/0155788", "Quadra 105 Bloco D, Cruzeiro Novo - DF", "M", true)
        );
        organizacoes = Arrays.asList(
                new Organization(0, "79.214.237/0001-25", "César e Felipe Marcenaria Ltda", "CF Marcenaria", "pesquisa@cesarfelipe.com.br", "(61) 3906-0035",
                        "www.cesarfelipe.com.br", "Empresa de Marcenaria", "Condomínio Residencial 833, Candangolândia - DF", "71725-020"),
                new Organization(1, "91.416.099/0001-62", "LE Contábil ME", "LE Contabil", "rh@le.com.br", "(61) 3620-6873",
                        "www.le.com.br", "Empresa de Contabilidade", "Quadra 10 Conjunto N, Gama - DF", "72415-514"),
                new Organization(2, "73.466.573/0001-89", "Joaquim e Renato Assessoria ME", "JR Assessoria", "comunicacoes@joaquimrenato.com.br", "(61) 3752-58893",
                        "www.joaquimrenato.com.br", "Empresa de Acessoria", "Quadra SHIS QI 11 Bloco J, Asa Sul - DF", "71625-585"),
                new Organization(3, "07.365.918/0001-83", "Valentina e Guilherme Ferragens ME", "VG Ferragens", "pesquisa@valentinaguilherme.com.br", "(61) 2816-9995",
                        "www.valentinaguilherme.com.br", "Empresa de Ferragens", "Setor Hoteleiro 4, 681, Gama - DF", "72405-604"),
                new Organization(4, "40.527.282/0001-02", "Kevin e Rafael Financeira Ltda", "KV Financeira", "fabricacao@kevinrafael.com.br", "(61) 3779-3020",
                        "www.kevinrafael.com.br", "Empresa de Financiamentos", "	Condomínio Privê II Quadra 5 Conjunto A, Lago Norte - DF", "71539-805"),
                new Organization(5, "47.709.905/0001-07", "Beatriz e Kaique Ltda", "BK Contabil", "vendas@beatrizkaique.com.br", "(61) 3903-9116",
                        "www.beatrizkaique.com.br", "Empresa de Contabilidade", "Quadra QS 4 Conjunto 6, Riacho Fundo I - DF", "71820-406"),
                new Organization(6, "59.948.552/0001-79", "Luiz Adega ME", "Luizadega", "luizadega@luizadega.com.br", "(61) 3593-2797",
                        "www.luizadega.com.br", "Empresa de Adegas", "Quadra CNR 1 Conjunto Q, Ceilândia-DF", "72275-182"),
                new Organization(7, "04.378.979/0001-97", "J Fortes Ltda", "J Fortes", "j@jfortes.com.br", "(61) 3558-2778",
                        "www.jfortes.com.br", "Empresa de Segurança", "Quadra 4 Conjunto F, Arapoanga, Planaltina -DF", "73368-512"),
                new Organization(8, "70.796.930/0001-89", "Miranda Pets Ltda", "Miranda Pets", "contato@mpets.com.br", "(61) 3558-2778",
                        "www.mpets.com.br", "Empresa de Animais de Estimação", "Quadra EQNL 17/19 Bloco B, Taguatinga - DF", "72151-522"),
                new Organization(9, "95.802.031/0001-72", "Sergio Madeiras Ltda", "Sergio Madeiras", "smadeiras@gmail.com.br", "(61) 3822-2602",
                        "Não possui", "Empresa de Marcenaria", "Quadra QNR 4 Área Especial 4 Ceilândia -DF", "72275-518"),
                new Organization(10, "92.516.066/0001-57", "Miragem Educação Ltda", "Miragem", "contato@miragem.com.br", "(61) 2742-8055",
                        "www.miragem.com.br", "Empresa de Produções Visuais", "Quadra 42 Conjunto D, Paranoá -DF", "71576-020"),
                new Organization(11, "31.605.272/0001-49", "Eliana Informática Ltda", "E Informática", "pessoal@Einfo.com.br", "(61) 3909-6083",
                        "www.einfo.com.br", "Empresa de Informática", "Quadra SHCES Quadra 809 Bloco A, Cruzeiro Novo -DF", "70655-891"),
                new Organization(12, "87.822.682/0001-04", "Jaime Negocios Ltda", "Castelo", "rh@castelo.com.br", "(61) 2964-0202",
                        "www.castelo.com.br", "Empresa de Materiais", "Quadra QC 1 Conjunto 2, Riacho Fundo II -DF", "71882-012"),
                new Organization(13, "62.901.983/0001-94", "Morata e Morata SA", "Morata", "info@morata.com.br", "(61) 3653-0371",
                        "www.morata.com.br", "Empresa de Visibilidade Social", "	Quadra EQNN 6/8 Bloco E, Ceilândia-DF", "72220-535"),
                new Organization(14, "73.962.079/0001-05", "Edgar Moura Ltda", "Pura Gente", "puragente@gmail.com.br", "(61) 3832-5858",
                        "Não possui", "Empresa de Visibilidade Social", "	Quadra QN 219, Samambaia-DF", "72345-050"),
                new Organization(15, "06.960.076/0001-45", "Geronimo de Souza ME", "GerSaude", "gersaude@gmail.com.br", "(61) 3885-5168",
                        "Não possui", "Empresa de Saude Coletiva", "Quadra QRSW 1 Bloco B-5, Setor Sudoeste -DF", "70675-125"),
                new Organization(16, "18.733.537/0001-26", "Farmacia do povo SA", "Farmacia do Povo", "informacoes@farmaciadopovo.com.br", "(61) 3590-1579",
                        "www.farmaciadopovo.com.br", "Empresa de Informatica", "Quadra C Conjunto 2, Gama-DF", "72420-432"),
                new Organization(17, "48.627.514/0001-06", "SG Servicos de Informática Ltda", "SG Info", "rh@sg.com.br", "(61) 3792-4234",
                        "www.sg.com.br", "Empresa de Informatica", "Quadra QR 304 Conjunto B, Santa Maria-DF", "72504-502"),
                new Organization(18, "14.991.575/0001-28", "Lopes e Cia ME", "Lopinho", "lops@gmail.com.br", "(61) 3792-4234",
                        "Não possui", "Empresa de Sustentabilidade", "	Quadra SQN 408 Bloco O, Asa Norte - DF", "70856-150"),
                new Organization(19, "06.370.192/0001-04", "Borges e Cia ME", "Beirute", "contato@beirute.com.br", "(61) 3363-6873",
                        "www.beirute.com.br", "Empresa de Alimentação", "Rua São Sebastião, Centro, São Sebastião-DF", "71691-087")
        );
        tags = Arrays.asList(
                new Tag(0, "Marcenaria", "Trabalhos com madeira"),
                new Tag(1, "Informática", "Trablhos de programação"),
                new Tag(2, "Educação", "Trabalhos para dar aulas"),
                new Tag(3, "Caridade", "Trabalhos de ajuda aos pobres"),
                new Tag(4, "Sustentabilidade", "Trabalhos de caráter ambiental"),
                new Tag(5, "Gênero", "Trabalhos com foco em questões de gênero"),
                new Tag(6, "Design", "Trabalhos de criação visual"),
                new Tag(7, "Arquitetura", "Trabalhos com empresas de arquiteura"),
                new Tag(8, "Saúde", "Trabalhos em hospitais, ou áreas da saúde"),
                new Tag(9, "Animais", "Trablhos com animais")
        );
        opportunities = Arrays.asList(
                new Opportunity(0, "Asa Norte", 5, "Madeira Hoje", "Trabalhos voluntários de marcenaria", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(0), R.drawable.logo),
                new Opportunity(1, "Asa Sul", 1, "Ajude nos Gastos", "Trabalhos voluntários de acessoria", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(1)),
                new Opportunity(2, "Lago Norte", 2, "Acessoria de Informação", "Trabalhos voluntários recolhimento de informações", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(2)),
                new Opportunity(3, "Cruzeiro", 4, "Meninas na sociedade", "Trabalhos de inserção de meninas na computação", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(3)),
                new Opportunity(4, "Samambaia", 2, "Acessoria Financeira", "Trabalhos voluntários de acessoria", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(4)),
                new Opportunity(5, "Taguatinga", 4, "Ajude nos gastos", "Trabalhos voluntários de acessoria", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(5)),
                new Opportunity(6, "Ceilândia", 5, "Doe um Brinquedo", "Trabalhos voluntários de coleta de doações", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(6)),
                new Opportunity(7, "São Sebastião", 8, "Fazer a Diferença", "Trabalhos voluntários de coleta de doações", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(7)),
                new Opportunity(8, "Riacho Fundo", 1, "A mudança em nós", "Trabalhos voluntários de sustentabilidade", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(8)),
                new Opportunity(9, "Núcleo Bandeirante", 2, "Todos pelo mesmo!", "Trabalhos que promovem a igualdade de gênero", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(9)),
                new Opportunity(10, "Gama", 4, "Education", "Trabalhos voluntários de ensino em escolas públicas", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(10)),
                new Opportunity(11, "Planaltina", 5, "InfoTudo", "Trabalhos voluntários informação da população", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(11)),
                new Opportunity(12, "Asa Norte", 8, "Materialize", "Trabalhos voluntários de criação de objetos com materiais reciclados", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(12)),
                new Opportunity(13, "Santa Maria", 4, "Morata", "Trabalhos voluntários de ajudas humanitárias", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(13)),
                new Opportunity(14, "Setor Sudoeste", 7, "Você Visível", "Trabalhos voluntários conscientização social", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(14)),
                new Opportunity(15, "Setor Noroeste", 5, "Saúde Voluntária", "Trabalhos voluntários conscientização social", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(15)),
                new Opportunity(16, "Gama", 8, "Saúde Hoje", "Trabalhos voluntários de conscientização social", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(16)),
                new Opportunity(17, "Asa Norte", 1, "Informatica +40", "Trabalhos voluntários inclusão digital", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(17)),
                new Opportunity(18, "Lago Norte", 3, "DF Sutentável", "Trabalhos voluntários de sustentabilidade", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(18)),
                new Opportunity(19, "Asa Sul", 1, "Cozinha para todos", "Trabalhos voluntários para levar comida aos pobres", getCalendar("01/01/2017"), getCalendar("01/02/2017"), organizacoes.get(19))
        );
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Calendar getCalendar(String data) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(formatoData.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return c;
    }

    public List<Voluntary> getVoluntaries() {
        return voluntaries;
    }

    public List<Organization> getOrganizacoes() {
        return organizacoes;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public Opportunity getOpportunitie(int id ){
        return opportunities.get(id);
    }
}
