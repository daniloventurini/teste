/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClienteTela.java
 *
 * Created on 06/12/2010, 22:02:15
 */
package visao;

import controle.CidadeControle;
import controle.ClienteControle;
import entidades.Cidade;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DANILO
 */
public class ClienteTela extends javax.swing.JFrame {

    private Cliente objeto;
    private ClienteControle controle;
    private List<Cliente> lista;
    private List<Cidade> cidades;
    private CidadeControle conCid;

    /** Creates new form ClienteTela */
    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            fNome.setEnabled(false);
            fApelido.setEnabled(false);
            dataCadastro.setEnabled(false);
            dataNascimento.setEnabled(false);
            fComplemento.setEnabled(false);
            fLocal.setEnabled(false);
            fReferencia.setEnabled(false);
            cCidade.setEnabled(false);
            fCelular.setEnabled(false);
            fCpf.setEnabled(false);
            fRg.setEnabled(false);
            fEndereco.setEnabled(false);
            fNumero.setEnabled(false);
            fCep.setEnabled(false);
            fTelefone.setEnabled(false);
            fBairro.setEnabled(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(true);
            btExcluir.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            tabela.setEnabled(true);
        } else if (acao.equals("novo") || acao.equals("alterar")) {
             fNome.setEnabled(true);
            fApelido.setEnabled(true);
            dataCadastro.setEnabled(true);
            dataNascimento.setEnabled(true);
            fComplemento.setEnabled(true);
            fLocal.setEnabled(true);
            fReferencia.setEnabled(true);
            cCidade.setEnabled(true);
            fCelular.setEnabled(true);
            fCpf.setEnabled(true);
            fRg.setEnabled(true);
            fEndereco.setEnabled(true);
            fNumero.setEnabled(true);
            fCep.setEnabled(true);
            fTelefone.setEnabled(true);
            fBairro.setEnabled(true);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);
            tabela.setEnabled(false);

        } else if (acao.equals("inicio") || acao.equals("cancelar") || acao.equals("salvar")) {
                fNome.setEnabled(false);
            fApelido.setEnabled(false);
            dataCadastro.setEnabled(false);
            dataNascimento.setEnabled(false);
            fComplemento.setEnabled(false);
            fLocal.setEnabled(false);
            fReferencia.setEnabled(false);
            cCidade.setEnabled(false);
            fCelular.setEnabled(false);
            fCpf.setEnabled(false);
            fRg.setEnabled(false);
            fEndereco.setEnabled(false);
            fNumero.setEnabled(false);
            fCep.setEnabled(false);
            fTelefone.setEnabled(false);
            fBairro.setEnabled(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            tabela.setEnabled(true);
        }



    }

     public boolean valida_CpfCnpj(String s_aux) {
        s_aux = s_aux.replace(".", "");
        s_aux = s_aux.replace("-", "");
//------- Rotina para CPF
        if (s_aux.length() == 11) {
            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++) {
                digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();
//--------- Multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                d1 = d1 + (11 - n_Count) * digitoCPF;
//--------- Para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                d2 = d2 + (12 - n_Count) * digitoCPF;
            }
            ;
//--------- Primeiro resto da divisão por 11.
            resto = (d1 % 11);
//--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;
//--------- Segundo resto da divisão por 11.
            resto = (d2 % 11);
//--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }
//--------- Digito verificador do CPF que está sendo validado.
            String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());
//--------- Concatenando o primeiro resto com o segundo.
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
//--------- Comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
            return nDigVerific.equals(nDigResult);
        } //-------- Rotina para CNPJ
        else if (s_aux.length() == 14) {
            int soma = 0, aux, dig;
            String cnpj_calc = s_aux.substring(0, 12);
            char[] chr_cnpj = s_aux.toCharArray();
//--------- Primeira parte
            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
//--------- Segunda parte
            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        } else {
            return false;
        }
    }


    public boolean verficaCampos() {
        if (fNome.getText().equals("") || fNome.getText() == null) {
            JOptionPane.showMessageDialog(null, "O campo nome do Funcionário deve ser preenchido!",
                    "Atenção!", JOptionPane.WARNING_MESSAGE);
            fNome.requestFocus();
            return false;
        } else if(fCpf.getText().equals("")|| fCpf.getText() == null) {
            JOptionPane.showMessageDialog(null, "O Campo CPF deve ser preenchido!", "Atenção!", JOptionPane.WARNING_MESSAGE
                    );
            fCpf.requestFocus();
            return false;
        }
        else if(fRg.getText().equals("")|| fRg.getText() == null) {
            JOptionPane.showMessageDialog(null, "O Campo RG deve ser preenchido!", "Atenção!", JOptionPane.WARNING_MESSAGE
                    );
            fRg.requestFocus();
            return false;
        } else if(valida_CpfCnpj(fCpf.getText())==false){
            JOptionPane.showMessageDialog(null, "Cpf Invalido!", "Atenção!", JOptionPane.WARNING_MESSAGE
                    );
            fCpf.requestFocus();
            return false;
        }
        else if(cCidade.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O Campo Cidade deve ser preenchido!", "Atenção!", JOptionPane.WARNING_MESSAGE
                    );
            cCidade.requestFocus();
            return false;
        }else{
        return true;
        }

    }

    public void montaTabela() {
        lista = controle.montaLista(cFiltro.getSelectedIndex(), fFiltro.getText());
       DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
        }

        };
        modelo.addColumn("Nome");
        modelo.addColumn("Cpf");
        modelo.addColumn("RG");
        for (Iterator<Cliente> it = lista.iterator(); it.hasNext();) {
            Cliente cliente = it.next();
            modelo.addRow(new Object[]{cliente.getNome(), cliente.getCpf(),cliente.getRg()});
        }
            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tabela.setModel(modelo);
        tabela.setRowSorter(sorter);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void montaCombo(){
    cidades = new ArrayList<Cidade>();
    cidades = conCid.listaTodos();

    cCidade.removeAllItems();
        for (Iterator<Cidade> it = cidades.iterator(); it.hasNext();) {
            Cidade ci = it.next();
            cCidade.addItem(ci.getNomeCidade());

        }
    }
    public Cliente getObjeto() {

        return objeto;
    }

    public void setObjeto(Cliente objeto) {
        this.objeto = objeto;

    }

    public ClienteTela() {
        initComponents();
        controle = ClienteControle.getInstance();
        conCid = CidadeControle.getInstance();
        montaCombo();
        limpaCombos();
        montaTabela();
        botoes("inicio");
    }

    public void limpaCombos(){
    cCidade.setSelectedItem(null);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fApelido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fBairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cCidade = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        fTelefone = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        fCelular = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        dataCadastro = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        fCpf = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        fRg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fReferencia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fLocal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fCep = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        dataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        fComplemento = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fFiltro = new javax.swing.JTextField();
        cFiltro = new javax.swing.JComboBox();
        btFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setText("Código");

        fId.setEditable(false);

        jLabel2.setText("Nome");

        jLabel3.setText("Apelido");

        jLabel5.setText("Endereço");

        jLabel6.setText("Numero:");

        jLabel7.setText("Bairro");

        fBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fBairroActionPerformed(evt);
            }
        });

        jLabel8.setText("Cidade");

        cCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Telefone");

        try {
            fTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setText("Celular");

        try {
            fCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setText("Data Cadastro");

        jLabel14.setText("CPF");

        try {
            fCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel15.setText("RG");

        jLabel9.setText("Referencia");

        jLabel10.setText("Local de Trabalho");

        jLabel16.setText("CEP:");

        try {
            fCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel17.setText("Data Nasc.");

        jLabel18.setText("Complemento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                                    .addComponent(fEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(fCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fRg, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fReferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fCep, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel13)
                        .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(fCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(fRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(fTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(fCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(fBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(fComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(fCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel4.setText("Filtro");

        cFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CPF", "RG" }));

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(fFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btFiltrar)
                    .addComponent(fFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

        botoes("novo");
        fId.setText("");
        fNome.setText("");
        fApelido.setText("");
        cCidade.setSelectedItem(null);
        fCelular.setText("");
        fCpf.setText("");
        fEndereco.setText("");
        fNumero.setText("");
        fRg.setText("");
        fTelefone.setText("");
        fBairro.setText("");
        dataCadastro.setDate(new Date());
        dataNascimento.setDate(new Date());
        fComplemento.setText("");
        fLocal.setText("");
        fReferencia.setText("");
        fCep.setText("");
        fApelido.setText("");





        fNome.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        if(objeto.getId()==null){
        JOptionPane.showMessageDialog(null, "Selecione um registro para Altarar!");
        }else{
        botoes("alterar");
        fNome.requestFocus();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        if(objeto.getId()==null){
        JOptionPane.showMessageDialog(null, "Selecione um registro para ser deletado!");
        }else{
        Object[] options = {"Sim", "Não"};
        int i = JOptionPane.showOptionDialog(null, "tem Certeza que deseja excluir este Registro?", "Atenção!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        if(i == JOptionPane.YES_OPTION){
        try{
        setObjeto(lista.get(tabela.getSelectedRow()));
        controle.excluir(objeto);
        montaTabela();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "O registro não pode  ser  " + "excluido pois possui dependências");

        }
        }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if(verficaCampos() == true){
        objeto = new Cliente();
        objeto.setNome(fNome.getText());
        objeto.setCpf(fCpf.getText());
        objeto.setCidade(cidades.get(cCidade.getSelectedIndex()));
        objeto.setBairro(fBairro.getText());
        objeto.setCelular(fCelular.getText());
        objeto.setRg(fRg.getText());
        objeto.setEndereco(fEndereco.getText());
        objeto.setNumero(Integer.parseInt(fNumero.getText()));
        objeto.setDataCadastro(dataCadastro.getDate());
        objeto.setDatanascimento(dataNascimento.getDate());
        objeto.setComplemento(fComplemento.getText());
        objeto.setLocaldeTrabalho(fLocal.getText());
        objeto.setReferencia(fReferencia.getText());
        objeto.setCep(fCep.getText());
        objeto.setApelido(fApelido.getText());
        objeto.setTelefone(fTelefone.getText());

        if(fId.getText().equals("")){
        objeto.setId(null);
        }else{
        objeto.setId(Long.parseLong(fId.getText()));
        }
        controle.salvar(objeto);
        botoes("salvar");
        montaTabela();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        botoes("cancelar");
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed

        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

        setObjeto(lista.get(tabela.getSelectedRow()));
        fId.setText(String.valueOf(objeto.getId()));
        fNome.setText(objeto.getNome());
        cCidade.setSelectedItem(objeto.getCidade().getNomeCidade());
        fCelular.setText(objeto.getCelular());
        fCpf.setText(objeto.getCpf());
        fEndereco.setText(objeto.getEndereco());
        fNumero.setText(String.valueOf(objeto.getNumero()));
        fRg.setText(objeto.getRg());
        fTelefone.setText(objeto.getTelefone());
        fBairro.setText(objeto.getBairro());
        dataCadastro.setDate(objeto.getDataCadastro());
        dataNascimento.setDate(objeto.getDatanascimento());
        fComplemento.setText(objeto.getComplemento());
        fLocal.setText(objeto.getLocaldeTrabalho());
        fReferencia.setText(objeto.getReferencia());
        fCep.setText(objeto.getCep());
        fApelido.setText(objeto.getApelido());
       botoes("selecionado");
         if(evt.getClickCount() == 2){
          if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para alterar!");
        } else {
            botoes("alterar");
            fNome.requestFocus();
        }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseClicked

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed

        montaTabela();
        // TODO add your handling code here:
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void fBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fBairroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClienteTela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cCidade;
    private javax.swing.JComboBox cFiltro;
    private com.toedter.calendar.JDateChooser dataCadastro;
    private com.toedter.calendar.JDateChooser dataNascimento;
    private javax.swing.JTextField fApelido;
    private javax.swing.JTextField fBairro;
    private javax.swing.JFormattedTextField fCelular;
    private javax.swing.JFormattedTextField fCep;
    private javax.swing.JTextField fComplemento;
    private javax.swing.JFormattedTextField fCpf;
    private javax.swing.JTextField fEndereco;
    private javax.swing.JTextField fFiltro;
    private javax.swing.JTextField fId;
    private javax.swing.JTextField fLocal;
    private javax.swing.JTextField fNome;
    private javax.swing.JTextField fNumero;
    private javax.swing.JTextField fReferencia;
    private javax.swing.JTextField fRg;
    private javax.swing.JFormattedTextField fTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
