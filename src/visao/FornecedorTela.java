/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FornecedorTela.java
 *
 * Created on 06/12/2010, 22:02:15
 */
package visao;

import controle.CidadeControle;
import controle.FornecedorControle;
import entidades.Cidade;
import entidades.Fornecedor;
import java.util.ArrayList;
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
public class FornecedorTela extends javax.swing.JFrame {

    private Fornecedor objeto;
    private FornecedorControle controle;
    private List<Fornecedor> lista;
    private List<Cidade> cidades;
    private CidadeControle conCid;

    /** Creates new form FornecedorTela */
    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            fNome.setEnabled(false);
            fRazao.setEnabled(false);
            cCidade.setEnabled(false);
            fFax.setEnabled(false);
            fCnpj.setEnabled(false);
            fEndereco.setEnabled(false);
            fNumero.setEnabled(false);
            fInscricao.setEnabled(false);
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
            fRazao.setEnabled(true);
            cCidade.setEnabled(true);
            fFax.setEnabled(true);
            fCnpj.setEnabled(true);
            fEndereco.setEnabled(true);
            fNumero.setEnabled(true);
            fInscricao.setEnabled(true);
            fTelefone.setEnabled(true);
            fBairro.setEnabled(true);
            btNovo.setEnabled(false);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);
            tabela.setEnabled(false);

        } else if (acao.equals("inicio") || acao.equals("cancelar") || acao.equals("salvar")) {
               fNome.setEnabled(false);
            fRazao.setEnabled(false);
            cCidade.setEnabled(false);
            fFax.setEnabled(false);
            fCnpj.setEnabled(false);
            fEndereco.setEnabled(false);
            fNumero.setEnabled(false);
            fInscricao.setEnabled(false);
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

    public boolean verficaCampos() {
        if (fNome.getText().equals("") || fNome.getText() == null) {
            JOptionPane.showMessageDialog(null, "O campo nome do Funcionário deve ser preenchido!",
                    "Atenção!", JOptionPane.WARNING_MESSAGE);
            fNome.requestFocus();
            return false;
        } else if(fRazao.getText().equals("")|| fRazao.getText() == null) {
            JOptionPane.showMessageDialog(null, "O Campo Razão Social deve ser preenchido!", "Atenção!", JOptionPane.WARNING_MESSAGE
                    );
            fRazao.requestFocus();
            return false;
        }
        else if(fCnpj.getText().equals("")|| fCnpj.getText() == null) {
            JOptionPane.showMessageDialog(null, "O Campo CNPJ deve ser preenchido!", "Atenção!", JOptionPane.WARNING_MESSAGE
                    );
            fCnpj.requestFocus();
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
        modelo.addColumn("Cnpj");
        modelo.addColumn("Incrição Est.");
        for (Iterator<Fornecedor> it = lista.iterator(); it.hasNext();) {
            Fornecedor fornecedor = it.next();
            modelo.addRow(new Object[]{fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getInscricao()});
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
    public Fornecedor getObjeto() {

        return objeto;
    }

    public void setObjeto(Fornecedor objeto) {
        this.objeto = objeto;

    }

    public FornecedorTela() {
        initComponents();
        controle = FornecedorControle.getInstance();
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
        fRazao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fBairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cCidade = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        fCnpj = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        fInscricao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fTelefone = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        fFax = new javax.swing.JFormattedTextField();
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
        setTitle("Cadastro de Fornecedor");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setText("Código");

        fId.setEditable(false);

        jLabel2.setText("Nome");

        jLabel3.setText("Razao Soc.");

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

        jLabel9.setText("CNPJ");

        try {
            fCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.####/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setText("Inscrição Est.");

        jLabel11.setText("Telefone");

        try {
            fTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setText("Fax");

        try {
            fFax.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNome, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel6))
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                            .addComponent(fEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                            .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fInscricao, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(fTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fFax, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(fNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(fBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(cCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(172, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(fCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(fInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(fTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel4.setText("Filtro");

        cFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CNPJ", "InscriE" }));

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(fFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
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
                        .addGap(43, 43, 43)
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
                        .addComponent(btSair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        fRazao.setText("");
        cCidade.setSelectedItem(null);
        fFax.setText("");
        fCnpj.setText("");
        fEndereco.setText("");
        fNumero.setText("");
        fInscricao.setText("");
        fTelefone.setText("");
        fBairro.setText("");


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
        objeto = new Fornecedor();
        objeto.setNome(fNome.getText());
        objeto.setRazaoSocial(fRazao.getText());
        objeto.setCidade(cidades.get(cCidade.getSelectedIndex()));
        objeto.setBairro(fBairro.getText());
        objeto.setFax(fFax.getText());
        objeto.setCnpj(fCnpj.getText());
        objeto.setEndereco(fEndereco.getText());
        objeto.setNumero(Integer.parseInt(fNumero.getText()));
        objeto.setInscricao(fInscricao.getText());
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
        fRazao.setText(objeto.getRazaoSocial());
        cCidade.setSelectedItem(objeto.getCidade().getNomeCidade());
        fFax.setText(objeto.getFax());
        fCnpj.setText(objeto.getCnpj());
        fEndereco.setText(objeto.getEndereco());
        fNumero.setText(String.valueOf(objeto.getNumero()));
        fInscricao.setText(objeto.getInscricao());
        fTelefone.setText(objeto.getTelefone());
        fBairro.setText(objeto.getBairro());


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
                new FornecedorTela().setVisible(true);
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
    private javax.swing.JTextField fBairro;
    private javax.swing.JFormattedTextField fCnpj;
    private javax.swing.JTextField fEndereco;
    private javax.swing.JFormattedTextField fFax;
    private javax.swing.JTextField fFiltro;
    private javax.swing.JTextField fId;
    private javax.swing.JTextField fInscricao;
    private javax.swing.JTextField fNome;
    private javax.swing.JTextField fNumero;
    private javax.swing.JTextField fRazao;
    private javax.swing.JFormattedTextField fTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
