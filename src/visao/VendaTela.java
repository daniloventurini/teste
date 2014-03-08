/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VendaTela.java
 *
 * Created on 11/01/2011, 18:29:04
 */
package visao;

import controle.ClienteControle;
import controle.ContasReceberControle;
import controle.ProdutoControle;
import controle.VendaControle;
import entidades.Cliente;
import entidades.ContasReceber;
import entidades.Produto;
import entidades.Venda;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class VendaTela extends javax.swing.JFrame {

    private Venda objeto;
    private VendaControle controle;
    private ContasReceberControle controleConta;
    private List<Venda> lista;
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private ClienteControle concli;
    private ProdutoControle conPro;

    public void botoes(String acao) {
        if (acao.equals("selecionado")) {
            cCliente.setEnabled(false);
            cFormaPagamento.setEnabled(false);
            fData.setEnabled(false);
            fValorDepositado.setEnabled(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(true);
            btExcluir.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            tabela.setEnabled(true);
            btAddItens.setEnabled(false);
        } else if (acao.equals("novo") || acao.equals("alterar")) {
            cCliente.setEnabled(true);
            cFormaPagamento.setEnabled(true);
            fData.setEnabled(true);
            fValorDepositado.setEnabled(true);
            btNovo.setEnabled(false);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);
            tabela.setEnabled(false);
            btAddItens.setEnabled(true);
        } else if (acao.equals("inicio") || acao.equals("cancelar")
                || acao.equals("salvar")) {
            cCliente.setEnabled(false);
            cFormaPagamento.setEnabled(false);
            fData.setEnabled(false);
            fValorDepositado.setEnabled(false);
            btNovo.setEnabled(true);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            tabela.setEnabled(true);
            btAddItens.setEnabled(false);
           
        }
    }

    public boolean verificaCampos() {
        if (cCliente.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "O Campo Cliente deve ser preenchido",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cCliente.requestFocus();
            return false;

        } else {
            return true;
        }
    }

    public void montaTabela() {
        lista = controle.listaCriterio(fFiltroData1.getDate(), fFiltroData2.getDate(), fFiltroCliente.getText());
         DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
        }

        };
        modelo.addColumn("Data");
        modelo.addColumn("Cliente");
        modelo.addColumn("Valor");
        modelo.addColumn("Valor Restante");

        for (Iterator<Venda> it = lista.iterator(); it.hasNext();) {
            Venda venda = it.next();
            modelo.addRow(new Object[]{venda.getDataVenda(), venda.getCliente().getNome(), venda.getValor(), venda.getValorRestante()});
        }

       RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        tabela.setModel(modelo);
        tabela.setRowSorter(sorter);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void montaComboCliente() {
        clientes = new ArrayList<Cliente>();
        clientes = concli.listaTodos();
        cCliente.removeAllItems();
        for (Iterator<Cliente> it = clientes.iterator(); it.hasNext();) {
            Cliente c = it.next();
            cCliente.addItem(c.getNome());
        }

    }

    public Venda getObjeto() {
        return objeto;
    }

    public void setObjeto(Venda objeto) {
        this.objeto = objeto;
    }

    /** Creates new form VendaTela */
    public VendaTela() {
        initComponents();
        controle = VendaControle.getInstance();
        concli = ClienteControle.getInstance();
        conPro = ProdutoControle.getInstance();
        controleConta = ContasReceberControle.getInstance();
        montaComboCliente();
        montaTabela();
        botoes("inicio");
    }

    public void limpaCombos() {
        cCliente.setSelectedItem(null);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fId = new javax.swing.JTextField();
        fData = new com.toedter.calendar.JDateChooser();
        cCliente = new javax.swing.JComboBox();
        cFormaPagamento = new javax.swing.JComboBox();
        fNumParcelas = new javax.swing.JSpinner();
        fValorTotal = new util.JMoneyField();
        fValorRestante = new util.JMoneyField();
        fValorDepositado = new util.JMoneyField();
        fValorEntrada = new util.JMoneyField();
        btAddItens = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        fFiltroCliente = new javax.swing.JTextField();
        btFiltrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fFiltroData1 = new com.toedter.calendar.JDateChooser();
        fFiltroData2 = new com.toedter.calendar.JDateChooser();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimentação Venda");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel1.setText("Código:");

        jLabel2.setText("Data:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Valor Total:");

        jLabel5.setText("Forma de Pagamento");

        jLabel6.setText("Valor Depositado:");

        jLabel7.setText("Valor Restante:");

        jLabel8.setText("Valor da Entrada:");

        jLabel9.setText("Num. de Parcelas:");

        fId.setEditable(false);

        cCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A Vista", "A prazo", "Cheque", "Parcelamento" }));

        fValorDepositado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fValorDepositadoKeyReleased(evt);
            }
        });

        btAddItens.setText("Produtos");
        btAddItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddItensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fValorEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fValorDepositado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fValorTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cFormaPagamento, javax.swing.GroupLayout.Alignment.LEADING, 0, 137, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fValorRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fNumParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAddItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(fData, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(fData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddItens))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fValorDepositado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(fValorRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fValorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(fNumParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

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

        jLabel10.setText("Cliente:");

        fFiltroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFiltroClienteActionPerformed(evt);
            }
        });

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        jLabel11.setText("Dt. Inicial");

        jLabel12.setText("Dt. Final");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFiltrar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fFiltroData1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fFiltroData2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fFiltroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12))
                    .addComponent(fFiltroData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fFiltroData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btSair))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSair, btSalvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fFiltroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFiltroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFiltroClienteActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        botoes("cancelar");        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

        botoes("novo");
        cCliente.setSelectedItem(null);
        fId.setText("");
        fValorTotal.setText("");
        fValorDepositado.setText("");
        fValorRestante.setText("");
        fData.setDate(new Date());
        fData.requestFocus();
        objeto = new Venda();
        // TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para ser excluido");
        } else {
            botoes("alterar");
            fData.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para ser excluido");

        } else {
            Object[] options = {"Sim", "Não"};
            int i = JOptionPane.showOptionDialog(null, "tem certeza que deseja excluir este registro", "Atenção", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (i == JOptionPane.YES_OPTION) {
                try {
                    setObjeto(lista.get(tabela.getSelectedRow()));
                    controle.excluir(objeto);
                    montaTabela();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "O registro não pode ser excluido pois"
                            + "possui dependencias");
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (verificaCampos() == true) {
            objeto.setCliente(clientes.get(cCliente.getSelectedIndex()));
            objeto.setPagamento(String.valueOf(cFormaPagamento.getSelectedItem()));
            objeto.setDataVenda(fData.getDate());
            String val = fValorTotal.getText().replace(".", "");
            val = val.replace(",", ".");
            objeto.setValor(new BigDecimal(val));

            String valDepositado = fValorDepositado.getText().replace(".", "");
            valDepositado = valDepositado.replace(",", ".");
            objeto.setValorDepositado(new BigDecimal(valDepositado));

            String valRest = fValorRestante.getText().replace(".", "");
            valRest = valRest.replace(",", ".");
            objeto.setValorRestante(new BigDecimal(valRest));

            if (cFormaPagamento.getSelectedIndex() == 1) {
                ContasReceber cr = new ContasReceber();
                cr.setCliente(objeto.getCliente());
                cr.setDataConta(objeto.getDataVenda());
                cr.setValor(objeto.getValor());
                controleConta.salvar(cr);
            }
            controle.salvar(objeto);
            botoes("salvar");
            montaTabela();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed

        montaTabela();
        // TODO add your handling code here:
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void btAddItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddItensActionPerformed

        if (verificaCampos() == true) {
            objeto.setDataVenda(fData.getDate());
            objeto.setCliente(clientes.get(cCliente.getSelectedIndex()));
            String valor = fValorTotal.getText();
            valor = valor.replace(".", ",");
            valor = valor.replace(",", ".");
            objeto.setValor(new BigDecimal(valor));
            if (fId.getText().equals("")) {
                objeto.setId(null);
            } else {
                objeto.setId(Long.parseLong(fId.getText()));
            }
            ItensVendaForm tela = new ItensVendaForm(new javax.swing.JFrame(), true, objeto);
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            objeto = tela.getObjVenda();
            fValorTotal.setText(String.valueOf(tela.getTotalGeral()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddItensActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        setObjeto(lista.get(tabela.getSelectedRow()));
        fId.setText(String.valueOf(objeto.getId()));
        if (objeto.getPagamento().equals("A vista")) {
            cFormaPagamento.setSelectedIndex(0);
        }
        if (objeto.getPagamento().equals("A prazo")) {
            cFormaPagamento.setSelectedIndex(1);
        }
        if (objeto.getPagamento().equals("Cheque")) {
            cFormaPagamento.setSelectedIndex(2);
        }
        cCliente.setSelectedItem(objeto.getCliente().getNome());
        fValorTotal.setText(String.valueOf(objeto.getValor()));
        fValorRestante.setText(String.valueOf(objeto.getValorRestante()));
        fValorDepositado.setText(String.valueOf(objeto.getValorDepositado()));
        fData.setDate(objeto.getDataVenda());

        botoes("selecionado");

    if(evt.getClickCount() == 2){
          if (objeto.getId() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para alterar!");
        } else {
            botoes("alterar");
            fData.requestFocus();
        }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseClicked

    private void fValorDepositadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fValorDepositadoKeyReleased

           String val = fValorTotal.getText().replace(".", "");
        val = val.replace(",", ".");

        String valDepositado = fValorDepositado.getText().replace(".", "");
        valDepositado = valDepositado.replace(",", ".");

        fValorRestante.setText(String.valueOf((new BigDecimal(val).subtract(new BigDecimal(valDepositado)))));
        // TODO add your handling code here:
    }//GEN-LAST:event_fValorDepositadoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VendaTela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddItens;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cCliente;
    private javax.swing.JComboBox cFormaPagamento;
    private com.toedter.calendar.JDateChooser fData;
    private javax.swing.JTextField fFiltroCliente;
    private com.toedter.calendar.JDateChooser fFiltroData1;
    private com.toedter.calendar.JDateChooser fFiltroData2;
    private javax.swing.JTextField fId;
    private javax.swing.JSpinner fNumParcelas;
    private util.JMoneyField fValorDepositado;
    private util.JMoneyField fValorEntrada;
    private util.JMoneyField fValorRestante;
    private util.JMoneyField fValorTotal;
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
